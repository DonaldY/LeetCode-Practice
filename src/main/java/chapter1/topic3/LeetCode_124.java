package chapter1.topic3;

/**
 * @author donald
 * @date 2020/5/8
 *
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * 题意：
 * 对于二叉树中任意两个节点，路径指的是从其中一个节点出发，经过它们的最近公共祖先，然后到达另一个节点的节点序列。
 * 另外，单个节点也算一条路径。注意，路径不一定会经过原始二叉树的根节点。
 *
 * 思路：
 * 1. 暴力法，递归算子树
 *    左子树、右子树、左子树+右子树+根，求总值
 * 2.
 */
public class LeetCode_124 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time: O(n^2), Space: O(n), Faster:  5.08%
    public int maxPathSumBruteForce(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = Math.max(maxPathSumFrom(root.left), 0);
        int rightMax = Math.max(maxPathSumFrom(root.right), 0);
        return max3(
                root.val + leftMax + rightMax,
                maxPathSumBruteForce(root.left),
                maxPathSumBruteForce(root.right)
        );
    }

    private int maxPathSumFrom(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(maxPathSumFrom(root.left), 0);
        int rightMax = Math.max(maxPathSumFrom(root.right), 0);
        return root.val + Math.max(leftMax, rightMax);
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Time: O(n), Space: O(n), Faster: 100.00%
    public int maxPathSumOn(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSumFromRootAndCompute(root, max);
        return max[0];
    }

    private int maxPathSumFromRootAndCompute(TreeNode root, int[] max) {
        if (root == null) return 0;
        int leftMax = Math.max(maxPathSumFromRootAndCompute(root.left, max), 0);
        int rightMax = Math.max(maxPathSumFromRootAndCompute(root.right, max), 0);
        max[0] = Math.max(max[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
