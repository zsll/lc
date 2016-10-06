public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String> ();
        if(words != null && words.length > 0 && board != null && board.length > 0 && board[0].length > 0) {
            int h = board.length, w = board[0].length;
            TrieNode root = new TrieNode();
            for(String s : words) {
                root.add(s, 0);
            }
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    HashSet<Integer> v = new HashSet<Integer>();
                    dfs(res, root.child[board[i][j] - 'a'], board, i, j,v);
                }
            }
        }
        return res;
    }
    
    void dfs(List<String> res, TrieNode cur, char[][] board, int i, int j, HashSet<Integer> v) {
        int h = board.length, w = board[0].length;
        if(cur != null) {
            if(cur.isWord && res.indexOf(cur.word) == -1) {
                res.add(cur.word);
            }
            v.add(i*w + j);
            int [][] dir = {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
            };
            for(int k = 0; k < 4; k++) {
                int x = dir[k][0] + i, y = dir[k][1] + j;
                if(x < h && x >= 0 && y < w && y >= 0 && !v.contains(x*w + y)) {
                    dfs(res, cur.child[board[x][y] - 'a'], board, x, y, v);
                }
            }
            v.remove(i*w + j);
        }
    }
    
    class TrieNode {
        TrieNode [] child = new TrieNode[26];
        boolean isWord = false;
        String word = null;
        
        public void add(String word, int start) {
            if(start == word.length()) {
                isWord = true;
                this.word = word;
            } else {
                char c = word.charAt(start);
                if(child[c - 'a'] == null) {
                    child[c - 'a'] = new TrieNode();
                }
                child[c - 'a'].add(word, start + 1);
            }
        }
        
        public boolean search(String word, int start) {
            if(start == word.length()) {
                return isWord;
            } else {
                char c = word.charAt(start);
                if(child[c - 'a'] == null) {
                    return false;
                }
                return child[c - 'a'].search(word, start + 1);
            }
        }
    }

}