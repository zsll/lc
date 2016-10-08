public class Solution {
    //There are 9 1 digit number, 90 2 digits ..., so 
    public int findNthDigit(int n) {
        long base  = 1, sum = 0, digit = 1, pre = 0;
        while(sum < n) {
            sum += digit*base*9;
            pre += base*9;
            base *=10;
            digit++;
        }
        digit--;
        base/=10;
        sum -= digit*base*9;    //0, 9, 189, ...
        pre -= base*9;  //0, 9, 90 ...
        long number = (n - sum - 1)/digit + pre + 1;    //0 based
        int res = Integer.toString((int)number).charAt((int)((n - sum - 1)%digit)) - '0';
        return res;
        
    }
}