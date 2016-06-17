/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head != null && head.next != null) {
        	ListNode cur = head, next = head.next;
        	while(next != null) {
        		if(next.val == cur.val) {
        			cur.next = next.next;
        			next = cur.next;
        		} else {
        			cur = next;
        			next = next.next;
        		}
        	}
        }
    	return head;
    }
}