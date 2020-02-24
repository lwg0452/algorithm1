package tree.and.graph._98ValidateBinarySearchTree;

import tree.and.graph._98ValidateBinarySearchTree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution3 {
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> leftMax = new Stack<>();
    Stack<Integer> rightMax = new Stack<>();
    public void update(TreeNode node, Integer min, Integer max) {
        stack.add(node);
        leftMax.add(min);
        rightMax.add(max);
    }

    public boolean isValidBST(TreeNode root) {
        Integer min = null, max = null;
        Integer val;
        update(root, min, max);
        while (!stack.isEmpty()) {
            root = stack.pop();
            min = leftMax.pop();
            max = rightMax.pop();
            if (root == null) {
                continue;
            }
            val = root.val;
            if (min != null && val <= min) {
                return false;
            }
            if (max != null && val >= max) {
                return false;
            }
            update(root.left,min,val);
            update(root.right,val,max);
        }
        return true;
    }
}
