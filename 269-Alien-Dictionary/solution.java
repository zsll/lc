public class Solution {
    public String alienOrder(String[] words) {
		List<Character> res = new ArrayList<Character>();
		if (words != null && words.length > 0) {
			HashSet<Character> charSet = new HashSet<Character>();
			for (String s : words) {
				for (char c : s.toCharArray()) {
					charSet.add(c);
				}
			}
			HashMap<Character, HashSet<Character>> dep = new HashMap<Character, HashSet<Character>>();
			boolean inputValid = getDep(words, dep);
			if(!inputValid) {
				return "";
			}
			HashMap<Character, Integer> v = new HashMap<Character, Integer>();
			for (char c : charSet) {
				if (dfs(dep, c, res, v)) {
					return "";	//has loop
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (char c : res) {
			sb.append(c);
		}
		return sb.toString();
	}

	// return has loop
	boolean dfs(HashMap<Character, HashSet<Character>> dep, char c, List<Character> res,
			HashMap<Character, Integer> v) {
		if (!v.containsKey(c)) {
			v.put(c, 1);
			if (dep.containsKey(c)) { // NoteNote
				for (char next : dep.get(c)) {
					if (dfs(dep, next, res, v)) {
						return true;
					}
				}
			}
			res.add(0, c);

			v.put(c, 2);
		} else if (v.get(c) == 1) {
			return true;
		}
		return false;
	}

	// key is dep, value is next, return if 
	boolean getDep(String[] words, HashMap<Character, HashSet<Character>> res) {
		
		if (words != null && words.length > 1) {
			for (int i = 1; i < words.length; i++) {
				int j = 0;
				String a = words[i - 1], b = words[i];
				while (j < a.length() && j < b.length() && a.charAt(j) == b.charAt(j)) {
					j++;
				}
				if (j < a.length() && j < b.length()) {
					if (!res.containsKey(a.charAt(j))) {
						res.put(a.charAt(j), new HashSet<Character>());
					}
					res.get(a.charAt(j)).add(b.charAt(j));
				} else if(j < a.length() && j == b.length()) {
					/*
					 * case 113/114, ["wrtkj","wrt"]

Isn't this a invalid input?
					 */
					return false;
				}
			}
		}
		return true;
	}
}