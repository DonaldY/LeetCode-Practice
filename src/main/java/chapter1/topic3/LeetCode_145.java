package chapter1.topic3;

import java.util.*;

/**
 * @author donald
 * @date 2020/5/31
 *
 * 145. Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * 题意：
 * 以后序遍历方式输出树节点
 *
 * 思路：
 * 1. 递归方式
 * 2. 迭代方式
 *    I. stack栈 + pre节点
 *    II. 链表 + stack栈
 */
public class LeetCode_145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        if (null == root) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        postorderTraversalRecursive(root, result);

        return result;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    private void postorderTraversalRecursive(TreeNode node, List<Integer> result) {

        if (null == node) return;

        postorderTraversalRecursive(node.left, result);
        postorderTraversalRecursive(node.right, result);

        result.add(node.val);
    }

    // Time: O(n), Space: O(n)
    public List<Integer> postorderTraversalIterater(TreeNode root) {

        if (null == root) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {

            if (root != null) {

                stack.push(root);
                root = root.left;
            } else {

                root = stack.peek().right;
                if (root == null || root == pre) {

                    pre = stack.pop();
                    result.add(pre.val);
                    root = null;
                }
            }
        }

        return result;
    }

    // Time: O(n), Space: O(n), Faster: 100.00%
    public List<Integer> postorderTraversalIterative2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return result;
    }

}
