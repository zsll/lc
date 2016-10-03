/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean res = true;
        if(head != null) {
            ListNode mid = findMid(head);
            
            ListNode h2 = mid.next;
            mid.next = null;
            ListNode rev = rev(h2);
            while(rev != null && head != null && rev.val == head.val) {
                rev = rev.next;
                head = head.next;
            }
            res = (rev == null && (head == null || head.next == null));
        }
        return res;
    }
    
    ListNode findMid(ListNode head) {
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    ListNode rev(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}