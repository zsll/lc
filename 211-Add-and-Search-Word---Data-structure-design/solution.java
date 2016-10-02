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
    
    class TrieNode {
    TrieNode [] children = new TrieNode[26];
    boolean isWord;
    
    public void add(String word, int startPos) {
        if(startPos == word.length()) {
            isWord = true;
        } else {
            char c = word.charAt(startPos);
            if(this.children[c - 'a'] == null) {
                this.children[c - 'a'] = new TrieNode();
            }
            this.children[c - 'a'].add(word, startPos + 1);
        }
    }
    
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
    
    void add(String word) {
        root.add(word, 0);
    }
    
    boolean search(String word) {
        return root.search(word, 0);
    }
}
}





// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");