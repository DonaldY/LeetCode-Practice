package chapter1.topic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * 题意： 中序遍历
 *
 * 思路：
 * 1. 模拟中序遍历，进行遍历, 递归遍历
 * 2. 先加根节点左边的数，在加根节点，再加根节点右边的树
 *
 */
public class LeetCode_94 {

    // Time: o(n), Space:o(n), Faster: 100%
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        traversal(result, root);

        return result;
    }

    private void traversal(List<Integer> result, TreeNode node) {

        if (node == null) return;

        if (node.left != null) traversal(result, node.left);
        result.add(node.val);
        if (node.right != null) traversal(result, node.right);
    }

    // Time: O(n). Space: O(n)
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> left = inorderTraversalRecursive(root.left);
        List<Integer> right = inorderTraversalRecursive(root.right);
        left.add(root.val);
        left.addAll(right);
        return left;
    }

    // Time: O(n). Space: O(n)
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (root != null || !s.empty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }
}
