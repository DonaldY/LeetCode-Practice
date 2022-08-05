package datastructure;

/**
 * @author donald
 * @date 2022/08/05
 *
 * 并查集，主要 2 个 API：
 * 1. 查找元素的根节点：查找 2 个节点是否连通
 * 2. 将 p 和 q 连接
 */
public class UnionFind {

    private int[] parent, size;

    public UnionFind(int n) {
        parent = new int[n];  //
        size = new int[n];    //
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 递归查找
    private int findRecursive(int x) {
        if (parent[x] == x) return x;
        return findRecursive(parent[x]);
    }
    // 递归查找，伴随压缩
    private int findPathCompressionRecursive(int x) {
        if (parent[x] == x) return x;
        parent[x] = findPathCompressionRecursive(parent[x]);
        return parent[x];
    }
    // 迭代查找
    private int findIterative(int x) {
        int root = x;
        while (parent[root] != root) root = parent[root];

        return root;
    }
    // 迭代查找，伴随压缩
    private int findPathCompressionIterative(int x) {
        int root = x;
        while (parent[root] != root) root = parent[root];
        while (parent[x] != root) {
            int tmp = parent[x];
            parent[x] = root;
            x = tmp;
        }
        return root;
    }

    // 1. 查找
    public int find(int x) {
        return findPathCompressionIterative(x);
    }

    // 2. 联合
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
