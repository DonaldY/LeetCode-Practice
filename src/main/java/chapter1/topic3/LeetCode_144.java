package chapter1.topic3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 *
 * 题意： 给一棵树，给出其前序遍历
 *
 * 题意： 按思路输出
 *
 * 思路：
 * 1. 递归
 * 2. 栈方式
 */
public class LeetCode_144 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        buildPreOrderList(root, result);

        return result;
    }

    private void buildPreOrderList(TreeNode root, List<Integer> result) {

        if (root == null) return;

        result.add(root.val);

        if (root.left != null) buildPreOrderList(root.left, result);
        if (root.right != null) buildPreOrderList(root.right, result);
    }

    // Time: O(n), Space: O(n)
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return result;
    }

    // Time: O(n), Space: O(n)
    public List<Integer> preorderTraversalIterative2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}
