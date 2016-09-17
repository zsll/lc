/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean res = false;
        if(head != null) {
            ListNode f = head.next, s = head;
            while(f != null && f.next != null) {
                if(f == s) {
                    res = true;
                    break;
                }
                f = f.next.next;
                s = s.next;
            }
        }
        return res;
    }
}