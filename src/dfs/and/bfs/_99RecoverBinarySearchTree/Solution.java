package dfs.and.bfs._99RecoverBinarySearchTree;

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
    TreeNode biggerNode = null;
    TreeNode smallerNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = biggerNode.val;
        biggerNode.val = smallerNode.val;
        smallerNode.val = temp;
        return;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.val < preNode.val) {
            if (biggerNode == null || biggerNode.val < preNode.val) {
                biggerNode = preNode;
            }
            if (smallerNode == null || root.val < smallerNode.val) {
                smallerNode = root;
            }
        }
        preNode = root;
        dfs(root.right);
        return;
    }
}
