public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Use 27 set, 9 for row, 9 for col, 9 for small grid
        List<HashSet<Integer>> rSet = new ArrayList<HashSet<Integer>>();
        List<HashSet<Integer>> cSet = new ArrayList<HashSet<Integer>>();
        List<HashSet<Integer>> bSet = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < 9; i++) {
            rSet.add(new HashSet<Integer>());
            cSet.add(new HashSet<Integer>());
            bSet.add(new HashSet<Integer>());
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int v = board[i][j];
                if(v != '.') {
                    if(!(rSet.get(i).add(v) && cSet.get(j).add(v) && bSet.get(i/3*3 + j/3).add(v))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}