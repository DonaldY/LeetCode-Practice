package datastructure;

/**
 * @author donald
 * @date 2022/08/05
 */
public class UnionFind {

    private int[] parent, size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int findRecursive(int x) {
        if (parent[x] == x) return x;
        return findRecursive(parent[x]);
    }

    private int findPathCompressionRecursive(int x) {
        if (parent[x] == x) return x;
        parent[x] = findPathCompressionRecursive(parent[x]);
        return parent[x];
    }

    private int findIterative(int x) {
        int root = x;
        while (parent[root] != root)
            root = parent[root];
        return root;
    }

    private int findPathCompressionIterative(int x) {
        int root = x;
        while (parent[root] != root)
            root = parent[root];
        while (parent[x] != root) {
            int tmp = parent[x];
            parent[x] = root;
            x = tmp;
        }
        return root;
    }

    public int find(int x) {
        return findPathCompressionIterative(x);
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        if (size[xRoot] < size[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    }

}
