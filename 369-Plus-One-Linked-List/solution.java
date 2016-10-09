/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode cur = d, before9 = null, last9 = null;
        ListNode pre = null;
        while(cur != null) {
            if(cur.val != 9 && cur.next != null && cur.next.val == 9) {
                before9 = cur;
            } else if(cur.val == 9) {
                last9 = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        if(pre.val != 9) {
            pre.val = pre.val + 1;
        } else {
            before9.val = before9.val + 1;
            cur = before9.next;
            while(cur != null) {
                cur.val = 0;
                cur = cur.next;
            }
        }
        if(d.val > 0) {
            return d;
        } else {
            return d.next;
        }
    }
}