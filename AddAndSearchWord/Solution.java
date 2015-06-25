public class WordDictionary {

    class TrieNode {
    
        Map<Character, TrieNode> next;
        
        // Initialize your data structure here.
        public TrieNode() {
            next = new HashMap<Character, TrieNode>();
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, word);     
    }
    
    public boolean searchHelper(TrieNode n, String word) {
        if (word == null) {
            return n.next.containsKey('\0');
        }
        
        char nextChar = word.charAt(0);
        
        if (nextChar == '.') {
            boolean res = false;
            String nextStr = (word.length() == 1) ? null : word.substring(1);
            for (Map.Entry<Character, TrieNode> entry : n.next.entrySet()) {
                if (!entry.getKey().equals('\0')) {
                    res |= searchHelper(entry.getValue(), nextStr);
                    if (res) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            if (n.next.containsKey(nextChar)) {
                String nextStr = (word.length() == 1) ? null : word.substring(1);
                return searchHelper(n.next.get(nextChar), nextStr);
            }
            else {
                return false;
            }
        }
        
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");