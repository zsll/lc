public class Solution {
 	    public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(words != null && words.length > 1) {
	            HashMap<String, Integer> sToI = new HashMap<String, Integer>();
	            for(int i = 0; i < words.length; i++) {
	                sToI.put(words[i], i);
	            }
	            HashSet<List<Integer>> v = new HashSet<List<Integer>>();
	            for(int i = 0; i < words.length; i++) {
	                String w = words[i];
	                for(int firstLen = 0; firstLen <= w.length(); firstLen++) {
	                    String firstHalf = w.substring(0, firstLen), secondHalf = w.substring(firstLen, w.length());
	                    if(isPalindrom(firstHalf)) {
	                        StringBuffer sb = new StringBuffer(secondHalf);
	                        String secondHalfRev = sb.reverse().toString();
	                        if(sToI.containsKey(secondHalfRev) && sToI.get(secondHalfRev) != i) {
	                            List<Integer> l = new ArrayList<Integer>();
	                            l.add(sToI.get(secondHalfRev));
	                            l.add(i);
	                            if(!v.contains(l)) {
	                                res.add(l);
	                                v.add(l);
	                            }
	                        }
	                    }
	                    if(isPalindrom(secondHalf)) {
	                        StringBuffer sb = new StringBuffer(firstHalf);
	                        String firstHalfRev = sb.reverse().toString();
	                        if(sToI.containsKey(firstHalfRev) && sToI.get(firstHalfRev) != i) {
	                            List<Integer> l = new ArrayList<Integer>();
	                            l.add(i);
	                            l.add(sToI.get(firstHalfRev));
	                            if(!v.contains(l)) {
	                                res.add(l);
	                                v.add(l);
	                            }
	                        }
	                    }
	                } 
	            }
	        }
	        return res;
	    }
	    
	    boolean isPalindrom(String s) {
	        int start = 0, end = s.length() - 1;
	        while(start < end && s.charAt(start) == s.charAt(end)) {
	            start++;
	            end--;
	        }
	        return start >= end;
	    }
}