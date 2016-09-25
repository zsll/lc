public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= num; i++) {
            int j = num - i;
            List<String> hours = getHours(i);
            List<String> minutes = getMinutes(j);
            for(String h : hours) {
                for(String m : minutes) {
                    res.add(h + ":" + m);
                }
            }
        }
        return res;
    }
    
    //1 2 4 8, So it's subset of size 0 to num out of 4, and needs to make sure the value is between 0 to 60
    List<String> getHours(int num) {
        List<String> res = new ArrayList<String>();
        if(num >= 0 && num <= 3) {
            int cur = 0;
            dfs(0, 0, num, true, cur, res);
        }
        return res;
    }
    
    void dfs(int start, int level, int target, boolean isHour, int cur, List<String> res) {
        int [] nums = {1, 2, 4, 8, 16, 32};
        if(level <= target) {
            if(level == target && (isHour && cur >= 0 && cur <= 11 || !isHour && cur >= 0 && cur <= 59)) {
                if(isHour) {
                    res.add(cur + "");
                } else {
                    if(cur <= 9) {
                        
                        res.add("0" + cur);
                    } else {
                        
                        res.add(cur + "");
                    }
                }
            } else if (level < target) {
                for(int i = start; i < nums.length; i++) {
                    cur += nums[i];
                    dfs(i + 1, level + 1, target, isHour, cur, res);
                    cur -= nums[i];
                }
            }
        }
    }
    
    //1 2 4 8 16 32, subset of size 0 to num out of 6, and needs to make sure the value is between 0 to 60
    List<String> getMinutes(int num) {
        List<String> res = new ArrayList<String>();
        if(num >= 0 && num <= 5) {
            int cur = 0;
            dfs(0, 0, num, false, cur, res);
        }
        return res;
    }
}