public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses];
        if(numCourses > 0) {
            HashMap<Integer, HashSet<Integer>> dep = new HashMap<Integer, HashSet<Integer>>();
            for(int i = 0; i < numCourses; i++) {
                dep.put(i, new HashSet<Integer>()); //key is pre, value is children
            }
            for(int i = 0; i < prerequisites.length; i++) {
                dep.get(prerequisites[i][1]).add(prerequisites[i][0]);    //To use dfs
            }
            List<Integer> l = new ArrayList<Integer>();
            HashMap<Integer, Integer> v = new HashMap<Integer, Integer>();
            boolean hasLoop = false;
            for(int i = 0; i < numCourses; i++) {
                if(dfs(dep, i, v, l)) {
                    hasLoop = true;
                    break;
                }
            }
            if(hasLoop) {
                return new int[0];
            }
            for(int i = 0; i < numCourses; i++) {
                res[i] = l.get(i);
            }
        }
        return res;
    }
    
    //return has loop
    boolean dfs(HashMap<Integer, HashSet<Integer>> dep, int cur, HashMap<Integer, Integer> v, List<Integer> res) {
        if(!v.containsKey(cur)) {
            v.put(cur, 0);  //visiting
            for(int next : dep.get(cur)) {
                if(dfs(dep, next, v, res)) {
                    return true;
                }
            }
            res.add(0, cur);
            v.put(cur, 1); //visited
        } else if(v.get(cur) == 0) {
            return true;
        }
        return false;
    }
}