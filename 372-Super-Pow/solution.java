public class Solution {
    //a^3 % 1337 = ( (a^1 % 1337) *(a^1 % 1337) *(a^1 % 1337) * (a^0 %1337) ) % 1337
    //a^11 % 1337 = ( (a^10 % 1337) * (a^1 %1337) ) % 1337
    //a^21 % 1337 = ( (a^10 % 1337) * (a^10 % 1337) * (a^1 %1337) ) % 1337
    //a^10 % 1337 = (a%1337 * a%1337 * a%1337 ... * a%1337)%1337
    //a^100 % 1337 = (a^10%1337 * a^10%1337 * a^10%1337 ... * a^10%1337)%1337
    public int superPow(int a, int[] b) {
        long base = a;
        long res = 1;
        for(int i = b.length - 1; i >= 0; i--) {
            long curDigitMod = 1;
            for(int j = 0; j < b[i]; j++) {
                curDigitMod = (base%1337 * curDigitMod)%1337;
            }
            res = (res*curDigitMod)%1337;
                if(res == 0) {
                    break;
                }
            long previousBase = base;
            base = 1;
            for(int j = 0; j < 10; j++) {
               base = (base*previousBase%1337)%1337;
            }
                
        }
        return (int)res;
    }
}