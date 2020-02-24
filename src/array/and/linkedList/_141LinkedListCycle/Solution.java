package array.and.linkedList._141LinkedListCycle;

import java.util.HashMap;

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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        HashMap hashMap = new HashMap();
        while (p != null) {
            if (!hashMap.containsKey(p)) {
                hashMap.put(p,p.val);
            } else {
                return true;
            }
            p = p.next;
        }
        return false;
    }
}