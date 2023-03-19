package data;

/**
 * Class to be used as dictionary node. This class is responsible for holding the position of a char. It also holds
 * the information about what is the next node in dictionary after this.
 */
public class TrieNode {
    /**
     * Defines if this is the end char for any word.
     */
    public boolean wordEnd;
    
    /**
     * Defines which chars are next char after this. If children[i] is non-null, then char i = 'a' is present as
     * next char for this node.
     */
    public final TrieNode[] children;
    
    /**
     * Initialize a trie node.
     */
    public TrieNode() {
        this.wordEnd = false;
        this.children = new TrieNode[26];
    }
}