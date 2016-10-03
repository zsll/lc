/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result = null;
        if(head != null) {
            HashMap<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
            RandomListNode cur = head, pre = null;
            while(cur != null) {
                RandomListNode n = new RandomListNode(cur.label);
                m.put(cur,n);
                if(pre != null) {
                    pre.next = n;
                }
                cur = cur.next;
                pre = n;
            }
            cur = head;
            while(cur != null) {
                if(cur.random != null) {
                    m.get(cur).random  = m.get(cur.random);
                }
                cur = cur.next;
            }
            result = m.get(head);
        }
        return result;
    }
}