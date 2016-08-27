public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0;
        int left = Math.max(A, E), right = Math.min(C, G), top = Math.min(D, H), bottom = Math.max(B, F);
        if(left < right && top > bottom) {
            overlap = (right - left)*(top - bottom);
        }
        int res = (C - A)*(D - B) + (G - E)*(H - F) - overlap;
        return res;
    }
}