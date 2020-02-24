package union.and.find;

public class UnionFind {
    public int[] roots;
    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i<n; i++) {
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
        roots[root2] = root1;
    }
}
