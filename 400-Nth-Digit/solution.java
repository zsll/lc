public class Solution {
    /*n位数的个数： 1位数有9， 2位99 - 9 = 90； 3位900 ... 4
    
    */
    public int findNthDigit(int n) {
        long sum = 0, i = 1, base = 9;
        int pre = 0; //i是位数
        while(sum < n) {
            sum += base*i;
            i++;
            pre += base;    //9 99 999
            base*=10;
        }
        i--;
        base/=10;
        pre -= base;
        n = n - (int)( sum - i*base);//在当前i位数中的第几位
        int numIndex = (int)((n - 1)/i);    //在当前i位数中的第几个(zero based)
        int number = pre + numIndex + 1, digit = (int)((n - 1)%i);
        return Integer.parseInt((Integer.toString(number)).charAt(digit) + "");
    }
    
    
}