package chapter3.topic1;

/**
 * @author donald
 * @date 2022/06/23
 *
 * 427. 建立四叉树
 *
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 *
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 *
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 *
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 *
 * 题意：将一个大区域划分为若干个小区域（要求每个小区域中的val全部一致），每次都是将一个大区域划分为4份（直到小区域val全部一致，终止）。
 *
 *  - 按照声明中的topLeft、topRight、bottomLeft以及bottomRight将一个大区域划分为4各小区域。
 *  - 使用for循环校验每个小区域中val是否全部一致。
 *  - 如果小区域不一致，则为非叶子结点，还可以继续划分（此时val为任意bool值）。
 *  - 如果小区域全部一致，则isLeaf此时设置val、isLeaf=true同时四个指针全部置空nullptr。
 *
 */
public class LeetCode_427 {

    private int[][] presum;

    // Faster: 21.98%
    public Node4 construct(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        presum = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                presum[i + 1][j + 1] = presum[i + 1][j] + presum[i][j + 1] - presum[i][j] + grid[i][j];
        return dfs(0, 0, m, n);
    }

    private Node4 dfs(int x0, int y0, int x1, int y1) {
        int diff = presum[x1][y1] - presum[x1][y0] - presum[x0][y1] + presum[x0][y0];
        if(diff == 0)
            return new Node4(false, true, null, null, null, null);
        if(diff == (x1 - x0) * (y1 - y0))
            return new Node4(true, true, null, null, null, null);
        int hx = (x0 + x1) / 2, hy = (y0 + y1) / 2;
        return new Node4(true, false,
                dfs(x0, y0, hx, hy),
                dfs(x0, hy, hx, y1),
                dfs(hx, y0, x1, hy),
                dfs(hx, hy, x1, y1));
    }
}

class Node4 {
    public boolean val;
    public boolean isLeaf;
    public Node4 topLeft;
    public Node4 topRight;
    public Node4 bottomLeft;
    public Node4 bottomRight;


    public Node4() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node4(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node4(boolean val, boolean isLeaf, Node4 topLeft, Node4 topRight, Node4 bottomLeft, Node4 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}