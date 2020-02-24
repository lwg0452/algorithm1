package array.and.linkedList._24SwapNodesInPairs;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode pre = head;
        head = head.next;
        while (b != null) {
            a.next = b.next;
            b.next = a;
            pre = a;
            a = a.next;
            if (a != null) {
                b = a.next;
                if (b != null) {
                    pre.next = b;
                } else {
                    pre.next = a;
                }
            } else {
                break;
            }
        }
        return head;
    }
}