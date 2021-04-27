package chapter5.topic3;

/**
 * @author donald
 * @date 2021/04/27
 *
 * LeetCode 938. 二叉搜索树的范围和
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * ```
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * ```
 *
 * 题意： 二叉搜索树的范围求和
 *
 * 思路：
 * 1. 直接遍历（怎么遍历都行）
 * 2. 中序排序生成数据，然后查找
 */
public class LeetCode_938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;
    // Time: O(n), Space: O(h), Faster: 55.17%
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null == root || low < 0 || high < 0) return 0;
        sumBST(root, low, high);
        return sum;
    }

    private void sumBST(TreeNode root, int low, int high) {
        if (null == root || low < 0 || high < 0) return;
        if (root.val >= low && root.val <= high) sum += root.val;
        sumBST(root.left, low, high);
        sumBST(root.right, low, high);
    }
}
