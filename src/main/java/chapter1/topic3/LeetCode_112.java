package chapter1.topic3;

/**
 * 112. Path Sum
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * 题意： 给一课二叉树和一个数，判断是否存在从根节点到叶子所有值之和等于一个数
 *
 * 思路：
 * 1. dfs一个个路径判断
 */
public class LeetCode_112 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null) {

            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
