/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k > 0 && head != null && head.next != null) {
	            int pos = 0;	//start position
	            ListNode p = head;
	            while(pos - 0 < k  && p.next != null) {	//Note to make Given 1->2->3->4->5->NULL and k = 2, 
	            	//and return 4->5->1->2->3->NULL. We need to make the slow pointer points to 3, and faster one points to 5
	                p = p.next;
	                pos++;
	            }
	            if(p.next == null) {
	            	int len = pos + 1;
	                k = k%len;
	                if(k > 0) {
		                pos = 0;
		                p = head;
		                while(pos < k) {
		                    p = p.next;
		                    pos++;
		                }
	                }
	            }
	            if(k > 0) {
	            	ListNode q = head;
	                while(p.next != null) {
	                	q = q.next;
	                	p = p.next;
	                }
	                p.next = head;
	                head = q.next;
	                q.next = null;
	            }
        	}
        	return head;
    }
}