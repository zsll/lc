/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = null;
        if(nums != null && nums.length > 0) {
            res = helper(nums, 0, nums.length - 1);
        }
        return res;
    }
    
    TreeNode helper(int[] nums, int start, int end) {
        TreeNode res = null;
        if(start <= end) {
            int mid = start + ( end - start >> 1);
            res = new TreeNode(nums[mid]);
            res.left = helper(nums, start, mid - 1);
            res.right = helper(nums, mid + 1, end);
        }
        return res;
    }
}