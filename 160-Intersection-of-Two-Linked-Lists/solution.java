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
        ListNode res = null;
        if(headA != null && headB != null) {
            int aLen = getLinkedListLen(headA), bLen = getLinkedListLen(headB);
            int diff = Math.abs(aLen - bLen);
            if(aLen >= bLen) {
                for(int i = 0; i < diff; i++) {
                    headA = headA.next;
                }
            } else {
                for(int i = 0; i < diff; i++) {
                    headB = headB.next;
                }
            }
            while(headA != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            if(headA != null) {
                res = headA;
            }
        }
        return res;
    }
    
    int getLinkedListLen(ListNode head) {
        int res = 0;
        while(head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}