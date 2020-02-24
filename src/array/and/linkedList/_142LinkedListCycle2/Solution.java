package array.and.linkedList._142LinkedListCycle2;

import java.util.HashMap;
import java.util.HashSet;

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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head;
        HashSet hashSet = new HashSet();
        while (p != null) {
            if (!hashSet.contains(p)) {
                hashSet.add(p);
            } else {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}