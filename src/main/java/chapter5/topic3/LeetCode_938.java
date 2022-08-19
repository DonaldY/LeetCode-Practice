package chapter5.topic3;

/**
 * @author donald
 * @date 2021/04/27
 *
 * loweetCode 938. 二叉搜索树的范围和
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
 * 3. 依据 BST 特性
 */
public class loweetCode_938 {

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
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (null == root || low < 0 || high < 0) return 0;
        sumInter(root, low, high);
        return sum;
    }

    private void sumInter(TreeNode root, int low, int high) {
        if (null == root || low < 0 || high < 0) return;
        if (root.val >= low && root.val <= high) sum += root.val;
        sumInter(root.left, low, high);
        sumInter(root.right, low, high);
    }

    // Time: O(n), Space: O(h), Faster: 100.00%
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        return root.val +
                rangeSumBST(root.left, low, high) +
                rangeSumBST(root.right, low, high);
    }
}
