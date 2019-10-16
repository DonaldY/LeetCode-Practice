package chapter3.topic3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 543. Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * 题意： 给你一棵二叉树，你要计算出这棵树的直径。二叉树的直径定义为树上任意两个节点之间最长路径的长度。
 * 其中，两个节点之间的路径不一定要经过根节点。
 *
 * 思路：
 * 1. 自顶向下查找
 * 2. 自下而上查找
 */
public class LeetCode_543 {

    // Time: O(n), Space: O(n), Faster: 100.00%
    public int diameterOfBinaryTree(TreeNode root) {
        int [] d = new int[1];
        maxDepth(root, d);
        return d[0];
    }

    private int maxDepth(TreeNode root, int[] d) {
        if (root == null) return 0;
        int left = maxDepth(root.left, d);
        int right = maxDepth(root.right, d);
        d[0] = Math.max(d[0], left + right);
        return Math.max(left, right) + 1;
    }

    // Time: O(n), Space: O(n), Faster: 13.96%
    public int diameterOfBinaryTreeIterative(TreeNode root) {
        if (root == null) return 0;
        int diameter = 0;
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node.left != null && !depthMap.containsKey(node.left)) {
                st.push(node.left);
            } else if (node.right != null && !depthMap.containsKey(node.right)) {
                st.push(node.right);
            } else {
                st.pop();
                int left = depthMap.getOrDefault(node.left, 0);
                int right = depthMap.getOrDefault(node.right, 0);
                diameter = Math.max(diameter, left + right);
                depthMap.put(node, Math.max(left, right) + 1);
            }
        }
        return diameter;
    }
}
