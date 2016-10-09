public class Solution {
     
    public String minAbbreviation(String target, String[] dictionary) {
        if(dictionary.length == 0) {
            return "" + target.length();
        }
        return generateAbbreviations(target, dictionary);
    }
    
    public String generateAbbreviations(String word, String[] dictionary) {
        String res = null;
        if(word != null) {
            List<String> cur = new ArrayList<String>();
            List<String> all = new ArrayList<String>();
            dfs(word, 0, cur, all, dictionary);
            res = all.get(0);
            for(int i = 1; i < all.size(); i++) {
                if(all.get(i).length() < res.length()) {
                    res = all.get(i);
                }
            }
        }
        return res;
    }
    
    //return the word if it works, else return null
    void dfs(String word, int pos, List<String> cur, List<String> res, String[] dictionary) {
        if(pos == word.length()) {
            StringBuffer sb = new StringBuffer();
            for(String s : cur) {
                sb.append(s);
            }
            String newS = new String(sb);
            boolean conf = false;
            /**
             * Submission Result: Wrong Answer More Details 

Input:
"apple"
["blade"]
Output:
"3l1"
Expected:
"a4"*/
            for(String d : dictionary) {
                if(validWordAbbreviation(d, newS)) {
                    conf = true;
                    break;
                }
            }
            if(!conf) {
                res.add(newS);
            }
        } else if (pos < word.length()) {
            if(cur.size() > 0 && !(cur.get(cur.size()  - 1).charAt(0) >= 'a' && cur.get(cur.size()  - 1).charAt(0) <= 'z')) {//previous is not char, in this case, can only increase previous number
                int pre = Integer.parseInt(cur.get(cur.size()  - 1));
                cur.remove(cur.size() - 1);
                cur.add((pre + 1) + "");
                dfs(word, pos + 1, cur, res, dictionary);
                cur.remove(cur.size() - 1);
                cur.add(pre + "");
            } else {
                cur.add("1");
                dfs(word, pos + 1, cur, res, dictionary);
                cur.remove(cur.size() - 1);
            }
            //We do this so during the dfs, shorter words will appear firstly. Forget it, it's wrong
            cur.add(word.charAt(pos) + "");
            dfs(word, pos + 1, cur, res, dictionary);
            cur.remove(cur.size() - 1);
        }
    }
    
    public boolean validWordAbbreviation(String word, String abbr) {
        boolean res = false;
        if(word != null && word.length() > 0 && abbr != null && abbr.length() > 0) {
        	int i = 0, j = 0;
        	res = true;
        	int cur = 0;
        	while(i < word.length() && j < abbr.length()) {
        	    if(!isN(abbr.charAt(j))) {
        	        if(abbr.charAt(j) != word.charAt(i)) {
        	            res = false;
        	            break;
        	        }
        	        cur = 0;
        	        i++;
        	        j++;
        	    } else {
        	    	if(cur == 0 && abbr.charAt(j) == '0') {
        	    		/**
        	    		 * Submission Result: Wrong Answer More Details 

Input:
"a"
"01"
Output:
true
Expected:
false
        	    		 */
        	    		res = false;
        	    		break;
        	    	}
        	        cur = cur*10 + abbr.charAt(j) - '0';
        	        if(j == abbr.length() - 1 || !isN(abbr.charAt(j + 1))) {
        	            i += cur;
        	        }
        	        j++;
        	    }
        	}
        	res = res && abbr.length() == j && i == word.length();
        }
        return res;
    }
    
    boolean isN(char c) {
        return c >= '0' && c <= '9';
    }
}