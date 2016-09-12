public class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        Map<Long, Integer> corners = new HashMap<>();
        int xmin = Integer.MAX_VALUE, ymin = xmin, xmax = Integer.MIN_VALUE, ymax = xmax;
        for (int[] r : rectangles) {
            if (!insertCorner(corners, (long)r[0]<<32 | r[1] & 0xffffffffL, 1<<0) ||
                !insertCorner(corners, (long)r[0]<<32 | r[3] & 0xffffffffL, 1<<1) ||
                !insertCorner(corners, (long)r[2]<<32 | r[1] & 0xffffffffL, 1<<2) ||
                !insertCorner(corners, (long)r[2]<<32 | r[3] & 0xffffffffL, 1<<3))  return false;
            xmin = Math.min(xmin, r[0]);
            xmax = Math.max(xmax, r[2]);
            ymin = Math.min(ymin, r[1]);
            ymax = Math.max(ymax, r[3]);
        }
        for (Map.Entry<Long, Integer> entry: corners.entrySet()) {
            int val = entry.getValue();
            if ((val & val - 1) == 0) { // 1, 2, 4, 8 Corner
                int x = (int)(entry.getKey() >>> 32), y = entry.getKey().intValue();
                if (x != xmin && x != xmax || y != ymin && y != ymax) return false;
            } else if (val != 3 && val != 5 && val != 10 && val != 12 && val != 15) {
                return false; // 15 Corss; others T-junction, cannot be 0110 or 1001!
            }
        }
        return true;
    }
    boolean insertCorner(Map<Long, Integer> corners, long corner, int pos) {
        int val = corners.getOrDefault(corner, 0);
        corners.put(corner, val | pos);
        return (val & pos) == 0;
    }
}