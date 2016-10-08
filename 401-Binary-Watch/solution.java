public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= num; i++) {
            List<String> l1 = pick(i, true);
            List<String> l2 = pick(num - i, false);
            for(String h : l1) {
                for(String m : l2) {
                    res.add(h + ":" + m);
                }
            }
        }
        return res;
    }
    
    List<String> pick(int num, boolean isHour) {
        int [] hours = {1, 2, 4, 8};
        int [] minutes = {1, 2, 4, 8, 16, 32};
        int [] a = isHour ? hours : minutes;
        Queue<Integer> preIndex = new LinkedList<Integer>();
        Queue<Integer> sum = new LinkedList<Integer>();
        sum.offer(0);
        preIndex.offer(-1);
        int count = 0;
        while(count < num && !sum.isEmpty()) {  //When sum is empty, it means it's impossible to get anything
            int size = preIndex.size();
            for(int i = 0; i < size; i++) {
                int preSum = sum.poll();
                int preI = preIndex.poll();
                for(int j = preI + 1; j < a.length; j++) {
                    sum.offer(preSum + a[j]);
                    preIndex.offer(j);
                }
            }
            count++;
        }
        List<String> res = new ArrayList<String>();
        while(!sum.isEmpty()) {
            int cur = sum.poll();
            if(isHour ) {
                if(cur < 12) {
                    res.add(Integer.toString(cur));
                }
            } else {
                if(cur < 10) {
                    res.add("0" + cur);
                } else if (cur < 60) {
                    res.add(Integer.toString(cur));
                }
            }
        }
        return res;
    }
}