/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int res = 0;
        if(n > 0) {
            int low = 1, high = n;
            while(low <= high) {
                int mid = low + (high - low >> 1);
                int g = guess(mid);
                if(g == 0){
                    res = mid;
                    break;
                } else if(g == -1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return res;
    }
}