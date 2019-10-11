package chapter2.topic1;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in
 * T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 *
 * 题意： 在二叉搜索树中查找两个节点的最近公共节点
 *
 * 思路：
 * 1. 把他们的父节点全都找出来，然后对比
 * 2. 递归
 * 3.
 */
public class LeetCode_235 {

    // 树的高度
    // Time: O(h), Space: O(h), Faster: 100.00%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (p.val < root.val && q.val > root.val) return root;
        if (p.val > root.val && q.val < root.val) return root;
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;

        if (p.val < root.val && q.val < root.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) return left;
        } else {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) return right;
        }

        return null;
    }

    // Time: O(h), Space: O(h)
    public TreeNode lcaRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lcaRecursive(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lcaRecursive(root.right, p, q);
        else return root;
    }

    // Time: O(h), Space: O(1)
    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }

}
