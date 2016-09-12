public class Solution {
    public boolean isSubsequence(String s, String t) {
		int sLen = s.length(), tLen = t.length();
		if (sLen == 0) return true;
		if (sLen > tLen) return false;
		int[] record = new int[tLen];
		int[] ptr = new int[26];
		int[] first = new int[26];
		for (int i = 0; i < 26; i++) first[i] = -1;
		for (int i = 0; i < tLen; i++) {
			int curr = t.charAt(i)-'a';
			record[i] = -1;
			if (first[curr] == -1) {
				first[curr] = i;
				ptr[curr] = i;
			}
			else {
				record[ptr[curr]] = i;
				ptr[curr] = i;
			}
		}
		int[] pos = new int[sLen];
		pos[0] = first[s.charAt(0)-'a'];
		if (pos[0] == -1) return false;
		for (int i = 1; i < sLen; i++) {
			int curr = s.charAt(i)-'a';
			int currPos = first[curr];
			while (currPos != -1 && currPos < pos[i-1]) {
				currPos = record[currPos];
			}
			if (currPos == -1) return false;
			first[curr] = record[currPos];
			pos[i] = currPos;
		}
		return true;
    }
}