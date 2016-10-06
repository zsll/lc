/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = getLen(headA), lB = getLen(headB);
        ListNode res = null;
        if(lA > 0 && lB > 0) {
            if(lA > lB) {
                for(int i = 0; i < lA - lB; i++) {
                    headA = headA.next;
                }
            } else {
                for(int i= 0; i < lB - lA; i++) {
                    headB = headB.next;
                }
            }
            while(headA != null && headB != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            res = headA;
        }
        return res;
    }
    
    int getLen(ListNode h) {
        int res = 0;
        while(h != null) {
            h = h.next;
            res++;
        }
        return res;
    }
}