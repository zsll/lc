public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int res = 0;
        if(image != null && image.length > 0 && image[0].length > 0 && x >= 0 && x < image.length && y >= 0 && y < image[0].length) {
            int left = firstBlackLeft(image, 0, y), up = firstBlackUp(image, x, image.length - 1),
            right = firstBlackRight(image, y, image[0].length - 1), down = firstBlackDown(image, 0, x);
            res = (right - left + 1)*(up - down + 1);
        }
        return res;
    }
    
    int firstBlackLeft(char[][] image, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(hasBlack(image, mid, false)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    int firstBlackUp(char[][] image, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(!hasBlack(image, mid, true)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
    
    int firstBlackRight(char[][] image, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(!hasBlack(image, mid, false)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
    
    
    
    int firstBlackDown(char[][] image, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(hasBlack(image, mid, true)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    boolean hasBlack(char[][] image, int index, boolean isRow) {
        int len = isRow ? image[0].length : image.length;
        for(int i = 0; i < len; i++) {
            if(isRow && image[index][i] == '1' || !isRow && image[i][index] == '1') {
                return true;
            }
        }
        return false;
    }
}