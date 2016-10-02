public class WordDictionary {
    Trie t = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        t.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return t.search(word);
    }
}

class TrieNode {
    TrieNode [] children = new TrieNode[26];
    boolean isWord;
    
    public boolean search(String word, int startPos) {
        if(startPos == word.length()) {
            
            return isWord;
        } else {
            if(word.charAt(startPos) == '.') {
                for(TrieNode n : children) {
                    if(n != null) {
                        if(n.search(word, startPos + 1)) {
                            return true;
                        }
                    }
                }
            } else {
                TrieNode n = children[word.charAt(startPos) - 'a'];
                if( n != null) {
                    return n.search(word, startPos + 1);
                }
            }
        }
        return false;
    }
}

class Trie {
    TrieNode root = new TrieNode();
    
    boolean add(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        boolean res = true;
        if(cur.isWord) {
            res = false;
        } else {
            cur.isWord = true;
        }
        return res;
    }
    
    boolean search(String word) {
        return root.search(word, 0);
    }
}



// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");