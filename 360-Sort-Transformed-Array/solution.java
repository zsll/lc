public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int [] res = null;
        if(nums != null && nums.length > 0) {
            int len = nums.length;
            res = new int[len];
            if(a == 0 && b == 0) {
                for(int i = 0; i < len; i++) {
                    res[i] = c;
                }
            } else if (a == 0) {
                if(b > 0) {
                    for(int i = 0; i < len; i++) {
                        res[i] = (int)((long)b*nums[i] + c);
                    }
                } else {
                    for(int i = 0; i < len; i++) {
                        res[i] = (int)((long)b*nums[len - i - 1] + c);
                    }
                }
            } else {
                //a(i*i + b/a + c/a)
                long axis = 0 - b/2/a;
                List<Long> l1 = new ArrayList<Long>();//before -b/2a
                List<Long> l2 = new ArrayList<Long>();//Make sure both are ascending
                int i = 0;
                while(i < len && nums[i] <= axis) {
                    long j = (long)nums[i];
                    if(a < 0) {
                        l1.add(a*j*j + b*j + c);
                    } else {
                        l1.add(0, a*j*j + b*j + c);
                    }
                    i++;
                }
                while(i < len) {
                    long j = (long)nums[i];
                    if(a > 0) {
                        l2.add(a*j*j + b*j + c);
                    } else {
                        l2.add(0, a*j*j + b*j + c);
                    }
                }
                res = merge2(l1, l2);
            }
        }
        return res;
    }
    
    int [] merge2(List<Long> l1, List<Long> l2) {
        int len = l1.size() + l2.size();
        int [] res = new int[len];
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()) {
            if(l1.get(i) < l2.get(j)) {
                res[i + j] = (int)(long)l1.get(i);//Can't directly from Long to int
                i++;
            } else {
                res[i + j] = l2.get(j).intValue();//or use intValue
                j++;
            }
        }
        while(i < l1.size()) {
            res[i + j] = (int)(long)l1.get(i);
            i++;
        }
        while(j < l2.size()) {
            res[i + j] = (int)(long)l2.get(j);
            j++;
        }
        return res;
    }
}