public class Solution {
 public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        HashMap<String, List<Integer>> h = new HashMap<String, List<Integer>>();
	        Trie trie = new Trie();
	        TrieReverse trieR = new TrieReverse();
	        for(int i = 0; i < words.length; i++) {
	            String r = reverse(words[i]);
	            if(!h.containsKey(r)) {
	                h.put(r, new ArrayList<Integer>());
	            }
	            h.get(r).add(i);
	            trie.insert(words[i], i);
	            trieR.insert(words[i], i);
	        }
	        
	        for(String k : h.keySet()) {
	            TrieNode pT = trie.startsWith(k);
	            if(pT != null) {
	                for(Integer i : pT.indexList) {
	                    for(Integer j : h.get(k)) {
	                        if(i != j) {
	                            List<Integer> l = new ArrayList<Integer>();
	                            l.add(i, j);
	                        }
	                    }
	                }
	            }
	            
	            pT = trieR.endsWith(k);
	            if(pT != null) {
	                for(Integer i : pT.indexList) {
	                    for(Integer j : h.get(k)) {
	                        if(i != j) {
	                            List<Integer> l = new ArrayList<Integer>();
	                            l.add(j, i);
	                        }
	                    }
	                }
	            }
	        }
	        return res;
	    }
	    
	    String reverse(String s) {
	        char [] a = s.toCharArray();
	        int i = 0, j = s.length() - 1;
	        while (i < j) {
	            char t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
	        return new String(a);
	    }
	    
	    class TrieNode {
	    	  
	        // Initialize your data structure here.
	        public HashMap<Character, TrieNode> children;
	        public boolean hasWord;	//note if hasWord equals true, the node is empty
	        public List<Integer> indexList;
	        
	        // Initialize your data structure here.
	        public TrieNode() {
	            children = new HashMap<Character, TrieNode>();	//NoteNote: each node might contain multiple chars
	            hasWord = false;
	            indexList = new ArrayList<Integer>();
	        }
	    }

	    public class Trie {
	        private TrieNode root;
	        
	        public TrieNode getRoot() {
	        	return root;
	        }

	        public Trie() {
	            root = new TrieNode();
	        }

	        // Inserts a word into the trie.
	        public void insert(String word, int idx) {
	            TrieNode now = root;
	            for(int i = 0; i < word.length(); i++) {
	                Character c = word.charAt(i);
	                if (!now.children.containsKey(c)) {
	                    now.children.put(c, new TrieNode());
	                }
	                now = now.children.get(c);
	                now.indexList.add(idx);
	            }
	            now.hasWord = true;
	            now.indexList.add(idx);
	        }

	        // Returns if the word is in the trie.
	        public TrieNode search(String word) {
	            TrieNode now = root;
	            for(int i = 0; i < word.length(); i++) {
	                Character c = word.charAt(i);
	                if (!now.children.containsKey(c)) {
	                    return null;
	                }
	                now = now.children.get(c);
	            }
	            if(now.hasWord) {
	                return now;
	            } else {
	                return null;
	            }
	        }

	        // Returns if there is any word in the trie
	        // that starts with the given prefix.
	        public TrieNode startsWith(String prefix) {
	            TrieNode now = root;
	            for(int i = 0; i < prefix.length(); i++) {
	                Character c = prefix.charAt(i);
	                if (!now.children.containsKey(c)) {
	                    return null;
	                }
	                now = now.children.get(c);
	            }
	            return now;
	        }
	        
	    }
	    

	    public class TrieReverse {
	        private TrieNode root;
	        
	        public TrieNode getRoot() {
	        	return root;
	        }

	        public TrieReverse() {
	            root = new TrieNode();
	        }

	        // Inserts a word into the trie.
	        public void insert(String word, int idx) {
	            TrieNode now = root;
	            for(int i = word.length() - 1; i >= 0; i--) {
	                Character c = word.charAt(i);
	                if (!now.children.containsKey(c)) {
	                    now.children.put(c, new TrieNode());
	                }
	                now = now.children.get(c);
	                now.indexList.add(idx);
	            }
	            now.hasWord = true;
	            now.indexList.add(idx);
	        }

	        // Returns if the word is in the trie.
	        public TrieNode search(String word) {
	            TrieNode now = root;
	            for(int i = word.length() - 1; i >= 0; i--) {
	                Character c = word.charAt(i);
	                if (!now.children.containsKey(c)) {
	                    return null;
	                }
	                now = now.children.get(c);
	            }
	            if(now.hasWord) {
	                return now;
	            } else {
	                return null;
	            }
	        }

	        // Returns if there is any word in the trie
	        // that starts with the given prefix.
	        public TrieNode endsWith(String postfix) {
	            TrieNode now = root;
	            for(int i = postfix.length() - 1; i >= 0; i--) {
	                Character c = postfix.charAt(i);
	                if (!now.children.containsKey(c)) {
	                    return null;
	                }
	                now = now.children.get(c);
	            }
	            return now;
	        }
	        
	    }
}