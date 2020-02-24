package dfs.and.bfs._113PathSumII;

import java.util.LinkedList;
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }
        List res = new LinkedList<>();
        dfs(res, root, sum, new LinkedList<Integer>());
        return res;
    }

    private void dfs(List res, TreeNode root, int sum, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                list.add(root.val);
                res.add(new LinkedList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            dfs(res, root.left, sum - root.val, list);
        }
        if (root.right != null) {
            dfs(res, root.right, sum - root.val, list);
        }
        list.remove(list.size() - 1);
        return;
    }
}
