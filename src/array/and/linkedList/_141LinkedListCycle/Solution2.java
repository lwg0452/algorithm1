package array.and.linkedList._141LinkedListCycle;

import java.util.HashMap;

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowP = head;
        ListNode fastP = head.next;
        while (fastP != null && slowP != null) {
            if (fastP.equals(slowP)) {
                return true;
            }
            slowP = slowP.next;
            if (fastP.next != null) {
                fastP = fastP.next.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
