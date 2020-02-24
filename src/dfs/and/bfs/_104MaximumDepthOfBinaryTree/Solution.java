package dfs.and.bfs._104MaximumDepthOfBinaryTree;

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
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int currentLevel) {
        if (node == null) {
            return currentLevel;
        }
        int leltLevel = helper(node.left, currentLevel + 1);
        int rightLevel = helper(node.right, currentLevel + 1);
        return Integer.max(leltLevel, rightLevel);
    }
}