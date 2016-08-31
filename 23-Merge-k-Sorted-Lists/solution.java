/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        if(lists != null && lists.length > 0) {
        int len = lists.length;
        
        res = helper(lists, 0, len - 1);
        }
        return res;
    }
    
    
    public ListNode helper(ListNode [] lists, int start, int end) {
        ListNode res = lists[start];
        if(start < end) {
            int mid = (end - start >> 1) + start;
            ListNode a = helper(lists, start, mid);
            ListNode b = helper(lists, mid + 1, end);
            res = merge(a, b);
        }
        return res;
    }
    
    ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), end = dummy;
        while(a != null && b != null) {
            if(a.val < b.val) {
                end.next = a;
                a = a.next;
            } else {
                
                end.next = b;
                b = b.next;
            }
            
                end = end.next;
                end.next = null;
        }
        
        while(a != null) {
            end.next = a;
            a = a.next;
            end = end.next;
            end.next = null;
        }
        
        while(b != null) {
            end.next = b;
            b = b.next;
            end = end.next;
            end.next = null;
        }
        return dummy.next;
    }
}