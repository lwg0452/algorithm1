package dfs.and.bfs._111MinimumDepthOfBinaryTree;

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 1);
    }

    public int helper(TreeNode node, int currentLevel) {
        if (node.left == null && node.right == null) {
            return currentLevel;
        }
        boolean leftFlag = false;
        boolean rightFlag = false;
        int leltLevel = currentLevel;
        if (node.left != null) {
            leftFlag = true;
            leltLevel = helper(node.left, currentLevel + 1);
        }
        int rightLevel = currentLevel;
        if (node.right != null) {
            rightFlag = true;
            rightLevel = helper(node.right, currentLevel + 1);
        }
        if (leftFlag == false) {
            return rightLevel;
        } else if (rightFlag == false) {
            return leltLevel;
        }
        return Integer.min(leltLevel, rightLevel);
    }
}
