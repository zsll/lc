public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;//cur is 45, next 450
            } else if (curr % 10 != 9 && curr + 1 <= n) { //n = 500, at 499, next should be 5, instead of 500, also, if at 299, next should be 3
                curr++;//cur is 
            } else {//if n = 600, at 499, next should be 500, becomes 
                do {	//the second digit from right
                    curr /= 10;
                } while (curr % 10 == 9);
                curr = curr + 1;
            }
        }
        return list;
    }
}