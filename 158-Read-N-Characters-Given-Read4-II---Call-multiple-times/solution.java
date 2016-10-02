/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     char [] b4 = new char[4];
     int offset = 0;
     int size = 0;
     
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        while(total < n && !eof) {
        int read = size;
            if(read == 0) {
                read = read4(b4);
                if(read < 4) {
                    eof = true;
                }
            }
            int toBeCopied = Math.min(n - total, read);
            for(int i = 0; i < toBeCopied; i++) {
                buf[total + i] = b4[offset + i];
            }
            total += toBeCopied;
            size = read - toBeCopied;
            offset = (offset + toBeCopied) % 4;
        }
        return total;
    }
}