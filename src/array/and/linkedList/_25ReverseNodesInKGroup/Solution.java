package array.and.linkedList._25ReverseNodesInKGroup;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (length < k) {
            return head;
        }
        ListNode result = head;
        for (int i = 1; i < k; i++) {
            result = result.next;
        }

        p = head;
        ListNode nextP = null;
        ListNode preP = null;

        while (length >= k) {
            if (preP != null) {
                ListNode nextK = p;
                for (int i = 1; i < k; i++) {
                    nextK = nextK.next;
                }
                preP.next = nextK;
            }

            for (int i = 0; i < k; i++) {
                nextP = p.next;
                p.next = preP;

                preP = p;
                p = nextP;
            }
            for (int i = 1; i < k; i++) {
                preP = preP.next;
            }
            preP.next = p;
            length -= k;
        }
        return result;
    }
}