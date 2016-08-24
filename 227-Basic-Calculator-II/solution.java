public class Solution {
    public int calculate(String s1) {
            int res = 0;
    if(s1 != null && s1.length() > 0) {
    	String newS = s1.replace(" ", "");
        String [] num = newS.split("[\\+\\-\\*/]");
        String [] operators = newS.split("[0-9]+");
        LinkedList<String> s = new LinkedList<String>();
        s.add(num[0].trim());
        for(int i = 1; i < operators.length; i++) {
            if(operators[i].trim().equals("+") || operators[i].trim().equals("-")) {
                s.add(operators[i].trim());
                s.add(num[i].trim());
            } else if(operators[i].trim().equals("*") || operators[i].trim().equals("/")) {
                int a = Integer.parseInt(s.removeLast());
                int b = Integer.parseInt(num[i].trim());
                if(operators[i].trim().equals("*")) {
                    s.add(Integer.toString(a * b));
                } else {
                    s.add(Integer.toString(a / b));
                }
            }
        }
        while(s.size() > 1) {
            int a = Integer.parseInt(s.remove());
            String oper = s.remove();
            int b = Integer.parseInt(s.remove());
            if(oper.equals("+")) {
                    s.add(0, Integer.toString(a + b));
                } else {
                    s.add(0, Integer.toString(a - b));
                }
        }
        res = Integer.parseInt(s.get(0));
    }
    return res;
    }
}