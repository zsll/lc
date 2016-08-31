public class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length() - 2; i++) {
            for(int j = i + 1; j < num.length() - 1; j++) {
                long num1 = Long.parseLong(num.substring(0, i + 1)),
                    num2 = Long.parseLong(num.substring(i + 1, j + 1));
                if(Long.toString(num1).equals(num.substring(0, i + 1)) &&
                    Long.toString(num2).equals(num.substring(i + 1, j + 1)) &&
                    isAddS(num.substring(j + 1, num.length()), num1, num2) ){
                        return true;
                    }
                    
            }
        }
        return false;
    }
    
    boolean isAddS(String num, long a, long b) {
        String s = Long.toString(a + b);
        if(s.length() <= num.length() && num.substring(0, s.length()).equals(s)) {
            if(num.length() == s.length() || isAddS(num.substring(s.length()), b, a + b)) {
                return true;
            }
        }
        return false;
    }
}