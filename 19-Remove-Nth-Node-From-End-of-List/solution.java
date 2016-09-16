/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        ListNode d = new ListNode(0);
        d.next = h;
    	ListNode pre = findNthFromEnd(d, n + 1); //Find the element before n;
    	if(pre != null && pre.next !=null) {
    		pre.next = pre.next.next;
    	}
    	return d.next;
    }
    
    public ListNode findNthFromEnd(ListNode h, int n) {
    	if(h == null) {
    		return null;
    	}
        ListNode pre = h, post = h;
        int i = 0;
        for(; i < n - 1 && post.next != null; i ++) {
        	post = post.next;
        }
        if(i < n - 1) {
        	return null;
        }
        while( post.next != null) {
        	post = post.next;
        	pre = pre.next;
        }
        return pre;
    }
}