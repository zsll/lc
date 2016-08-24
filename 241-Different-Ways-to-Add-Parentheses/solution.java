public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        boolean foundOper = false;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(isOper(c)) {
                foundOper = true;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for(Integer a : left) {
                    for(Integer b : right) {
                        if (c == '+') {
                            res.add(a + b);
                        } else if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        } else {
                            res.add(a/b);
                        }
                    }
                }
            }
        }
        if(!foundOper) {
            res.add(Integer.parseInt(input));
        } 
        return res;
    }
    
    boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}