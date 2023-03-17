package p208;

class Trie {
    private final TrieNode root;
    
    public Trie() {
        this.root = new TrieNode(' ');
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null)
                node.children[index] = new TrieNode(c);
            node = node.children[index];
        }
        node.completeWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null)
                return false;
            
            node = node.children[index];
        }
        return node.completeWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }
    
    private static class TrieNode {
        public char c;
        public boolean completeWord;
        public TrieNode [] children;
        
        public TrieNode(char c) {
            this.c = c;
            this.completeWord = false;
            this.children = new TrieNode[26];
        }
    }
}