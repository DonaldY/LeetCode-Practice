package datastructure;

/**
 * @author donald
 * @date 2022/08/05
 *
 * 并查集，主要 2 个 API：
 * 1. 查找元素的根节点：查找 2 个节点是否连通
 * 2. 将 p 和 q 连接
 *
 * 并查集的关键在于如何把原问题转化成图的动态连通性问题。
 */
public class UnionFind {

    private int[] parent, size;

    public UnionFind(int n) {
        parent = new int[n];  // 存储每个节点的父节点
        size = new int[n];    // 记录每棵树的 “重量”
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

        // 小树接到大树下面，较平衡
        if (size[xRoot] < size[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    }

}
