package dfs.and.bfs._106ConstructBinaryTreeFromInorderAndPostorderTraversal;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int postIndex, int inStart, int inEnd) {
        if (postIndex < 0 || inStart > inEnd) {
            return null;
        }
        int inIndex = inStart;
        TreeNode root = new TreeNode(postorder[postIndex]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] != postorder[postIndex]) {
                continue;
            }
            inIndex = i;
            break;
        }
        root.right = build(inorder, postorder, postIndex - 1, inIndex + 1, inEnd);
        root.left = build(inorder, postorder, postIndex - 1 - (inEnd - inIndex), inStart, inIndex - 1);
        return root;
    }
}