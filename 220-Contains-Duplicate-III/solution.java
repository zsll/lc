public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
SortedSet<Long> set = new TreeSet<Long>();
for (int j = 0; j < nums.length; j++) {
long leftBoundary = (long) nums[j] - t;
long rightBoundary = (long) nums[j] + t + 1; SortedSet<Long> subSet = set.subSet(leftBoundary,
rightBoundary);
if (!subSet.isEmpty())
return true;
set.add((long) nums[j]);
if (j >= k) {
set.remove((long) nums[j - k]);
} }
return false;
    }
}