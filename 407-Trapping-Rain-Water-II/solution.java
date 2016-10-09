public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        if(heightMap != null && heightMap.length > 2 && heightMap[0].length > 2) {
            PriorityQueue<PosH> pq = new PriorityQueue<PosH>(10, new Comparator<PosH>() {
               public int compare(PosH a, PosH b) {
                   return a.h - b.h;
               } 
            });
            int h = heightMap.length, w = heightMap[0].length;
            
            HashSet<Integer> v = new HashSet<Integer>();
            for(int i = 0; i < w; i++) {
                PosH p = new PosH(0, i, heightMap[0][i]);
                pq.offer(p);
                v.add(0*w + i);
                p = new PosH(h - 1, i, heightMap[h - 1][i]);
                pq.offer(p);
                v.add((h - 1)*w + i);
            }
            for(int i = 1; i < h - 1; i++) {
                PosH p = new PosH(i, 0, heightMap[i][0]);
                pq.offer(p);
                v.add(i*w);
                p = new PosH(i, w - 1, heightMap[i][w - 1]);
                pq.offer(p);
                v.add(i*w + w - 1);
            }
            
            int [][] dir = {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
            };
            while(!pq.isEmpty()) {
                PosH cur = pq.poll();
                for(int k = 0; k < 4; k++) {
                    int x = dir[k][0] + cur.i, y = dir[k][1] + cur.j;
                    if(x >= 0 && x < h && y >= 0 && y < w && !v.contains(x*w + y)) {
                        if(cur.h > heightMap[x][y]) {
                            res += (cur.h - heightMap[x][y]);
                            PosH p = new PosH(x, y, cur.h);
                            pq.offer(p);
                        } else {
                            PosH p = new PosH(x, y, heightMap[x][y]);
                            pq.offer(p);
                        }
                        v.add(x*w + y);
                    }
                }
            }
        }
        return res;
    }
    
    class PosH {
        int i, j, h;
        public PosH(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }
}