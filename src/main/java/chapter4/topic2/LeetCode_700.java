package chapter4.topic2;

/**
 * 700. Search in a Binary Search Tree
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 *
 * 二叉搜索树的定义是：
 *
 *   1. 左子树所有节点上的值都小于根节点上的值
 *   2. 右子树所有节点上的值都大于根节点上的值
 *   3. 左右子树同时也为二叉搜索树
 *
 * 题意：在二叉搜索树中查找对应的值
 *
 * 思路：递归查找
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_700 {

    // Time: o(h), Space: o(h), Faster: 100.00%
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;

        int value = root.val;

        if (value == val) return root;

        if (val < value) {

            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // Time: o(h), Space: o(1), Faster: 100.00%
    public TreeNode searchBSTIterative(TreeNode root, int val) {

        while (root != null && val != root.val) {
            if (val < root.val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}
