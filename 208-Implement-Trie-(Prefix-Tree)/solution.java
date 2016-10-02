class TrieNode {
    // Initialize your data structure here.
    HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
    boolean isWord = false;
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(!cur.child.containsKey(c)) {
                TrieNode t = new TrieNode();
                cur.child.put(c, t);
            }
            cur = cur.child.get(c);
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        boolean res = true;
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(!cur.child.containsKey(c)) {
                res = false;
                break;
            }
            cur = cur.child.get(c);
        }
        return res && cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        boolean res = true;
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            if(!cur.child.containsKey(c)) {
                res = false;
                break;
            }
            cur = cur.child.get(c);
        }
        return res;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");