package chapter2.topic1;


/**
 * 226. Invert Binary Tree
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 题意：翻转二叉树
 *
 * 思路：
 * 1. 递归处理
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_226 {

    // Time: o(n), Space: o(1), Time: 100.00%
    public TreeNode invertTree(TreeNode root) {

        invertTreeNode(root);

        return root;
    }

    private void invertTreeNode(TreeNode node) {

        if (node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) invertTreeNode(node.left);
        if (node.right != null) invertTreeNode(node.right);
    }
}
