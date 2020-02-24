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
class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return Integer.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
