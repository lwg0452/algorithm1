package dfs.and.bfs._109ConvertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> sorted = new ArrayList<>();
        while (head != null) {
            sorted.add(head.val);
            head = head.next;
        }
        return build(sorted, 0, sorted.size() - 1);
    }

    private TreeNode build(List<Integer> sorted, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left = build(sorted,start, mid-1);
        root.right = build(sorted, mid + 1, end);
        return root;
    }
}
