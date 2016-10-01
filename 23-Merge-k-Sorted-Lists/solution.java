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
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        } else {
            int mid = start + (end - start >> 1);
            ListNode a = mergeKListsHelper(lists, start, mid);
            ListNode b = mergeKListsHelper(lists, mid + 1, end);
            return merge(a, b);
        }
    }
    
    ListNode merge(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), cur = d;
        while(a != null && b != null) {
            if(a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        while(a != null) {
            cur.next = a;
            a = a.next;
            cur = cur.next;
        }
        while(b != null) {
            cur.next = b;
            b = b.next;
            cur = cur.next;
        }
        return d.next;
    }
}