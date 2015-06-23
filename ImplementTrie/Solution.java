class TrieNode {

    Map<Character, TrieNode> next;
    
    // Initialize your data structure here.
    public TrieNode() {
        next = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        
        int i = 0, n = word.length();
        while (i < n) {
            char nextChar = word.charAt(i);
            if (node.next.containsKey(nextChar)) {
                node = node.next.get(nextChar);
                i ++;
            }
            else {
                break;
            }
        }
        
        while (i < n) {
            char nextChar = word.charAt(i);
            TrieNode nextNode = new TrieNode();
            node.next.put(nextChar, nextNode);
            node = nextNode;
            i ++;
        }
        
        node.next.put('\0', null);  // Indicate end of word
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode n = root;
        
        for (int i = 0; i < word.length(); i ++) {
            char nextChar = word.charAt(i);
            if (n.next.containsKey(nextChar)) {
                n = n.next.get(nextChar);
            }
            else {
                return false;
            }
        }
        return n.next.containsKey('\0');    // Check if the word ends
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        
        for (int i = 0; i < prefix.length(); i ++) {
            char nextChar = prefix.charAt(i);
            if (n.next.containsKey(nextChar)) {
                n = n.next.get(nextChar);
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");