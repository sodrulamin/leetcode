package p211;

import data.TrieNode;

public class WordDictionary {
    /**
     * Starting pointer of the dictionary
     */
    private final TrieNode root;
    
    /**
     * Initialize the dictionary.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /**
     * Add the given word into this dictionary.
     * @param word String word to be added into this dictionary.
     */
    public void addWord(String word) {
        TrieNode node = root;
        
        //algorithm we are storing a word is called Trie.
        //Each char is indexed from 0 to 25.
        for (int i = 0; i < word.length(); i++) {
            //get the current char
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        
        //the end node must be marked as word end node. So, that we can match it while search.
        node.wordEnd = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    /**
     * Search the given word recursively in this dictionary. At every step of this method, it will match only one single
     * char and then call the method recursively until it reaches the end of the word.
     *
     * @param word String to be searched in this dictionary.
     * @param index current index of given word to be matched in this dictionary.
     * @param node current node of this dictionary.
     * @return true, if a match is found otherwise, return false.
     */
    private boolean search(String word, int index, TrieNode node) {
        //if we have reached the end of the word, then we must return true, if the current node is end of any word
        // inserted into this dictionary
        if(index == word.length())
             return node.wordEnd;
        
        //get the current char. If the current char is a . we must check every available child of current node.
        int ch = word.charAt(index);
        if(ch == '.') {
            for(int i = 0; i < node.children.length; i++) {
                //if we can find a match with any one child of current node, we must return true,
                if(node.children[i] != null && search(word, index + 1, node.children[i]))
                    return true;
            }
            
            //we have searched all children of current but found no match.
            return false;
        }
        
        //this is not a . so, we should find exact match.
        ch -= 'a';
        return node.children[ch] != null && search(word, index + 1, node.children[ch]);
    }
}
