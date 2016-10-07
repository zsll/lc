public class Solution {
    public int trap(int[] height) {
        int res = 0;
        if(height != null && height.length > 2) {
            int i = 0, j = height.length - 1;
            while(i < j) {
                if(height[i] < height[j]) {
                    int k = i + 1;
                    while(k < j && height[k] <= height[i]) {
                        res += (height[i] - height[k]);
                        k++;
                    }
                    i = k;
                } else {
                    int k = j - 1;
                    while(k > i && height[k] <= height[j]) {
                        res += (height[j] - height[k]);
                        k--;
                    }
                    j = k;
                }
            }
        }
        return res;
    }
}