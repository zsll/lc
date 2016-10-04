/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode pre = d;
        while(head != null && head.next != null) {
            ListNode n = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = n;
            pre = head;
            head = n;
        }
        return d.next;
    }
}