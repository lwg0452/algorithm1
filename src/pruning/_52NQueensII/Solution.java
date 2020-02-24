package pruning._52NQueensII;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<Integer> shuSet = new HashSet<>();
    public Set<Integer> pieSet = new HashSet<>();
    public Set<Integer> naSet = new HashSet<>();
    public int res = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        dfs(n, 0, new int[n][n]);
        return res;
    }

    public void dfs(int n, int currentRow, int[][] currentBoard) {
        if (currentRow >= n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!shuSet.contains(col) && !pieSet.contains(currentRow + col) && !naSet.contains(currentRow - col)) {
                currentBoard[currentRow][col] = 1;
                shuSet.add(col);
                pieSet.add(currentRow + col);
                naSet.add(currentRow - col);
                dfs(n, currentRow + 1, currentBoard);
                currentBoard[currentRow][col] = 0;
                shuSet.remove(col);
                pieSet.remove(currentRow + col);
                naSet.remove(currentRow - col);
                continue;
            }
        }
        return;
    }
}