/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int res = 0;
        char [] b = new char[4];
        while (res < n && !eof) {
            int read = read4(b);
            if(read < 4) {
                eof = true;
            }
            int toCopy = Math.min(read, n - res);
            for(int i = 0; i < toCopy; i++) {
                buf[res + i] = b[i];
            }
            res += toCopy;
        }
        return res;
    }
}