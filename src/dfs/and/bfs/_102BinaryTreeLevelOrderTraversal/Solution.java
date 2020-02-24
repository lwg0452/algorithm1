package dfs.and.bfs._102BinaryTreeLevelOrderTraversal;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        TreeNode start = root;
        boolean isStart = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (start.equals(node)) {
                if (!node.equals(root)) {
                    res.add(list);
                }
                list = new ArrayList<>();
                isStart = true;
            }
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                if (isStart == true) {
                    start = node.left;
                    isStart = false;
                }
            }
            if (node.right != null) {
                queue.add(node.right);
                if (isStart == true) {
                    start = node.right;
                    isStart = false;
                }
            }
        }
        if (!list.isEmpty()) {
            res.add(list);
        }
        return res;
    }
}