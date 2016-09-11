/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
       
        while (low <= high) {
            int mid = low+(high-low)/2;
            int guessResult = guess(mid);
            if (guessResult == 0)
                return mid;

            if (guessResult == 1)
                low = mid+1;
            else if (guessResult == -1) 
                high = mid-1;
        }
        
        return -1;
    }
}