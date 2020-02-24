package dfs.and.bfs._22GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(n, res, "", 0, 0);
        return res;
    }

    public void helper(int n, List<String> list, String str, int leftNum, int rightNum) {
        if (rightNum > leftNum) {
            return;
        }

        if (leftNum < n) {
            helper(n, list, str + '(', leftNum + 1, rightNum);
        }
        if (rightNum < leftNum && rightNum < n) {
            helper(n, list, str + ')', leftNum, rightNum + 1);
        }

        if (leftNum == n && rightNum == n) {
            list.add(str);
        }
        return;
    }
}
