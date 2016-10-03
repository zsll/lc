public class Solution {
    public String alienOrder(String[] words) {
    				HashMap<Character, Set<Character>> dep = buildEdge(words);
    				Set<Character> v = new HashSet<Character>();
    				StringBuffer b = new StringBuffer();
    				for(Character c : dep.keySet()) {
    					search(v, dep, b, c);
    				}
    				return b.toString();
    			}
    			
    			public void search(Set<Character> v, HashMap<Character, Set<Character>> dep, StringBuffer b, Character c) {
    				if(!v.contains(c)) {
    					if(dep.containsKey(c)) {	//NoteNote: when getting a key from hash, have to make sure it exists
    						for(Character neighbor : dep.get(c)) {
    							search(v, dep, b, neighbor);
    						}
    					}
    					b.insert(0, c);
    					v.add(c);
    				}
    			}
    			
    			/**
    			 * Return HashMap<Character, Set<Character>>, key is from, set is to
    			 * @param words
    			 * @return
    			 */
    			public HashMap<Character, Set<Character>> buildEdge(String[] words) {
    				HashMap<Character, Set<Character>> res = new HashMap<Character, Set<Character>>();
    				for(int i = 1; i < words.length; i++) {
    					for(int j = 0; j < words[i - 1].length() && j < words[i - 1].length(); j++) {
    						if(words[i - 1].charAt(j) != words[i].charAt(j)) {
    							if(res.containsKey(words[i - 1].charAt(j))) {
    								res.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
    							} else {
    								Set<Character> s = new HashSet<Character>();
    								s.add(words[i].charAt(j));
    								res.put(words[i - 1].charAt(j), s);
    							}
    							break;
    						}
    					}
    				}
    				return res;
    			}
    		   
}