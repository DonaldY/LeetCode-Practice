package chapter1.topic3;

import java.util.Stack;

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
 * 1. dfs一个个路径判断:
 *    递归法，每递归到一个节点，就拿target-当前节点值，如果存在路径总和等于target，那么最后一个叶子节点一定等于target剩下的值。
 *    如果递归到叶子节点后，剩余的target值不等于叶子节点，说明不存在路径总和等于target。
 *
 * 2. 迭代方式： 使用栈
 */
public class LeetCode_112 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;

        // 叶子节点
        if (root.left == null && root.right == null) {

            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    // Time: o(n), Space: o(n), Faster: 12.69%
    public boolean hasPathSumIterative(TreeNode root, int sum) {

        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(sum);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            int s = sumStack.pop();
            if (n.left == null && n.right == null && n.val == s) return true;
            if (n.left != null) {
                stack.push(n.left);
                sumStack.push(s - n.val);
            }
            if (n.right != null) {
                stack.push(n.right);
                sumStack.push(s - n.val);
            }
        }
        return false;
    }
}
