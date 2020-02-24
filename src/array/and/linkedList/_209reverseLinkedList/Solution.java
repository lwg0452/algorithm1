package array.and.linkedList._209reverseLinkedList;


public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prep = null;
        ListNode p = head;
        while (p != null) {
            ListNode nextp = p.next;
            p.next = prep;
            prep = p;
            p = nextp;
        }
        return prep;

    }
}
