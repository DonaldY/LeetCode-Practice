package chapter5.topic1;

/**
 * @author donald
 * @date 2022/10/13
 *
 * 思路： DFS， 判断自身和子树是否全为 0
 */
public class LeetCode_814 {
    // Time: O(n), Space: O(1), Faster: 100.00%
    public TreeNode pruneTree(TreeNode root) {
        if (null == root) return null;

        boolean isLeftZero = dfsTree(root.left);
        boolean isRightZero = dfsTree(root.right);

        if (isLeftZero) root.left = null;
        if (isRightZero) root.right = null;

        // 左右子树的值均为 0 且 自己的值为0， 则这个树均不要
        return isLeftZero && isRightZero && root.val == 0 ? null : root;
    }

    private boolean dfsTree(TreeNode root) {
        if (null == root) return true; // 节点为 null， 也表示可以删除

        boolean isLeftZero = dfsTree(root.left);
        boolean isRightZero = dfsTree(root.right);

        if (isLeftZero) root.left = null;
        if (isRightZero) root.right = null;

        // 是否包含值 1
        return isLeftZero && isRightZero && root.val == 0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}