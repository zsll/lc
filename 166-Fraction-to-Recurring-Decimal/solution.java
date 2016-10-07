public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        StringBuffer sb = new StringBuffer();
        boolean isNeg = numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0;
        if(isNeg) {
            sb.append("-");
        }
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        /** NoteNote abs of int would result in
         * /**
     * if use int instead of long
     * Input:	-1, -2147483648
Output:	"-0.000000000-4-6-5-6-6-1-2-8-7-30-7-7-3-9-2-5-7-8-1-2-5"
Expected:	"0.0000000004656612873077392578125"
     */
        sb.append(n/d);
        long mod = n%d;
        if(mod > 0) {
            sb.append(getDecimal(mod, d));
        }
        return sb.toString();
    }
    
    String getDecimal(long mod, long denom) {
        StringBuffer sb = new StringBuffer();
        List<Long> l = new ArrayList<Long>();
        List<Long> res = new ArrayList<Long>();
        l.add(mod);
        int prePos = -1;
        while(mod > 0) {
            res.add(mod*10/denom);
            mod = mod*10%denom;
            prePos = l.indexOf(mod);
            if(prePos >= 0) {
                break;
            }
            l.add(mod);
        }
        sb.append(".");
        if(prePos >= 0) {
            for(int i = 0; i < prePos; i++) {
                sb.append(res.get(i));
            }
            sb.append("(");
            for(int i = prePos; i < l.size(); i++) {
                sb.append(res.get(i));
            }
            sb.append(")");
        } else {
            for(int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
            }
        }
        return sb.toString();
    }
}