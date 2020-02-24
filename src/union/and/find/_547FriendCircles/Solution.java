package union.and.find._547FriendCircles;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    //并查集
    public int[] roots;
    public int count;

    public void generateUnionFind(int[][] grid) {
        int n = grid.length;
        roots = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
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

    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int size = M.length;
        generateUnionFind(M);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (M[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        return count;
    }
}