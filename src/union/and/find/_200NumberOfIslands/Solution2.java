package union.and.find._200NumberOfIslands;

class Solution2 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    //并查集
    public int[] roots;
    public int count;

    public void generateUnionFind(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        roots = new int[m * n];
        count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
        for (int i = 0; i < m * n; i++) {
            roots[i] = i;
        }
    }

    public int find(int x) {
        int root = x;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (roots[x] != root) {
            int temp = roots[x];
            roots[x] = root;
            x = temp;
        }
        return root;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if (root1 == root2) {
            return;
        }
        roots[root2] = root1;
        count--;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        generateUnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
                            union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return count;
    }
}
