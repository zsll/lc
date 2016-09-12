public class Solution {
    public boolean isSubsequence(String s, String t) {
		int sLen = s.length(), tLen = t.length();
		if (sLen == 0) return true;
		if (sLen > tLen) return false;
		int[] record = new int[tLen];
		int[] ptr = new int[26];
		int[] first = new int[26];
		for (int i = 0; i < 26; i++) first[i] = -1;	//first appearance pos of char int t
		for (int i = 0; i < tLen; i++) {	//firstly scan the longer template t
			int curr = t.charAt(i)-'a';
			record[i] = -1;
			if (first[curr] == -1) {	//never appeared before in t
				first[curr] = i;
				ptr[curr] = i;	//last appearance pos of char in t
			}
			else {
				record[ptr[curr]] = i;	//next appearance pos int t
				ptr[curr] = i;
			}
		}
		int[] pos = new int[sLen];	//pos[i] has the last appearance of s.charAt(i) in t
		int [] firstCopy = new int[26];
		System.arraycopy(first, 0, firstCopy, 0, 26);
		
		for (int i = 0; i < sLen; i++) {
			int charInS = s.charAt(i)-'a';
			int posInT = firstCopy[charInS];//first appearance in t
			if(i > 0) {	//Else don't have to consider have to be larger than previous position
				while (posInT != -1 && posInT <= pos[i-1]) {	//first appearance of last character
					posInT = record[posInT];
				}
			}
			if (posInT == -1) return false;
			firstCopy[charInS] = record[posInT];//go to next pos in t
			pos[i] = posInT;
		}
		return true;
    }
}