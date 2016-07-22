public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        if(envelopes != null && envelopes.length > 0) {
            List<Envelope> envList = new ArrayList<Envelope>();
            for(int i = 0; i < envelopes.length; i++) {
                envList.add(new Envelope(envelopes[i][0], envelopes[i][1]));
            }
            Collections.sort(envList, new Comparator<Envelope>() {
               @Override
               public int compare(Envelope a, Envelope b) {
                   /**
                    * To avoid the following error since same width can't hold
                    * Input:
[[5,4],[6,4],[6,7],[2,3]]
Output:
4
Expected:
3*/
                   if(a.width == b.width) {
                       return Integer.compare(b.height, a.height);
                   }
                   return Integer.compare(a.width, b.width);
               }
            });
            int len = envList.size();
            int [] b = new int[len + 1];
            res = 1;
            b[1] = envList.get(0).height;
            for(int i = 1; i < len; i++) {
                if(b[res] < envList.get(i).height) {
                    b[++res] = envList.get(i).height;
                } else {
                    int pos = searchPos(envList.get(i).height, b, res - 1);
                    b[pos] = envList.get(i).height;
                }
            }
        }
        return res;
    }
    
    int searchPos(int height, int [] b, int end) {
        int start = 0, res = 0;
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(b[mid] >= height) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    class Envelope {
        int width, height;
        public Envelope(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}