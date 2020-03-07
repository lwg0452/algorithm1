package dynamic.programming._95UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        dp[1] = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        dp[1].add(root);
        for (int len = 2; len <= n; len++) {
            dp[len] = new ArrayList<>();
            for (int r = 1; r <= len; r++) {
                for (TreeNode left : dp[r - 1]) {
                    int remain = len - r;
                    for (TreeNode right : dp[remain]) {
                        TreeNode node = new TreeNode(r);
                        node.left = left;
                        node.right = doOffset(right, r);
                        dp[len].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode doOffset(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + offset);
        node.left = doOffset(root.left, offset);
        node.right = doOffset(root.right, offset);
        return node;
    }
}
