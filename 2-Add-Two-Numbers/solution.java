/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0);
        ListNode pre = d;
        int car = 0;
        while(l1 != null && l2 != null) {
            ListNode n = new ListNode((l1.val + l2.val + car)%10);
            pre.next = n;
            pre = n;
            car = l1.val + l2.val + car >= 10 ? 1 : 0;//NoteNote the equal
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            ListNode n = new ListNode((l1.val  + car)%10);
            pre.next = n;
            pre = n;
            car = l1.val + car >= 10 ? 1 : 0;
            l1 = l1.next;
        }
        while(l2 != null) {
            ListNode n = new ListNode((l2.val  + car)%10);
            pre.next = n;
            pre = n;
            car = l2.val + car >= 10 ? 1 : 0;
            l2 = l2.next;
        }
        if(car > 0) {
            ListNode n = new ListNode(1);
            pre.next = n;
        }
        return d.next;
    }
}