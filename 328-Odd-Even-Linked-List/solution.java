/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode res = head;
        if(head != null && head.next != null) {
            ListNode oddDummy = new ListNode(0), evenDummy = new ListNode(0), oddEnd = oddDummy, evenEnd = evenDummy;
            int i = 1;
            while(head != null) {
                if(i%2 > 0) {
                    oddEnd.next = head;
                    head = head.next;
                    oddEnd = oddEnd.next;
                    oddEnd.next = null;
                } else {
                    evenEnd.next = head;
                    head = head.next;
                    evenEnd = evenEnd.next;
                    evenEnd.next = null;
                }
                i++;
            }
            oddEnd.next = evenDummy.next;
            res = oddDummy.next;
        }
        return res;
    }
}