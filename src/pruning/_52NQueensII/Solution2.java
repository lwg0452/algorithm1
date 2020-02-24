package pruning._52NQueensII;

class Solution2 {

    public int res = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        dfs(n, 0, 0, 0, 0);
        return res;
    }

    public void dfs(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            res++;
            return;
        }
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int b = bits & (-bits);
            dfs(n, row + 1, col | b, (pie | b) << 1, (na | b) >> 1);
            bits = bits & (bits - 1);
        }
        return;
    }
}
