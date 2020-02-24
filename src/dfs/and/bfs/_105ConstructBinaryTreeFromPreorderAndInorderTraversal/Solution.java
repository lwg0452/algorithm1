package dfs.and.bfs._105ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] != preorder[preStart]) {
                continue;
            }
            rootIndex = i;
            break;
        }
        TreeNode left = buildTree(preStart + 1, inStart, rootIndex - 1, preorder, inorder);
        TreeNode right = buildTree(preStart + (rootIndex - inStart) + 1, rootIndex + 1, inEnd, preorder, inorder);
        root.left = left;
        root.right = right;
        return root;
    }
}
