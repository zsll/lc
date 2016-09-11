/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        int i = 0;
        while(head != null) {
            map.put(i, head.val);
            head = head.next;
            i++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int size = map.size();
        Random r = new Random();
        int i = r.nextInt(size);
        return map.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */