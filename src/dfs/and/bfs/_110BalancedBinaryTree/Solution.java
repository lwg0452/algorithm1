package dfs.and.bfs._110BalancedBinaryTree;

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeLevel(root.left, 1);
        int right = treeLevel(root.right, 1);
        if (Math.abs(left-right)>1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeLevel(TreeNode root,int level) {
        if (root == null) {
            return level;
        }
        level++;
        int left = treeLevel(root.left, level);
        int right = treeLevel(root.right, level);
        return Math.max(left, right);
    }
}
