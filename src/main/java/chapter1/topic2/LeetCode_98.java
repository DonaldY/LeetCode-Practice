package chapter1.topic2;

/**
 * 98. Validate Binary Search Tree
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * 题意： 判断是否是二叉搜索树
 *
 * 思路：
 * 1. 递归查询
 * 2. 至顶向下，判断上下界
 */
public class LeetCode_98 {

    TreeNode min(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    TreeNode max(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // Time: o(nlog(n)) , Space: o(1), Faster: 37.68%
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftValid = root.left == null || root.val > max(root.left).val;
        boolean rightValid = root.right == null || root.val < min(root.right).val;
        return leftValid && rightValid && isValidBST(root.left) && isValidBST(root.right);
    }

    // Time: o(n), Space: 0(n), Faster: 100.00%
    public boolean isValidBSTBound(TreeNode root) {
        return isValidBSTBound(root, null ,null);
    }

    boolean isValidBSTBound(TreeNode root, TreeNode lower, TreeNode upper) {
        if (root == null) return true;
        if (lower != null && lower.val >= root.val) return false;
        if (upper != null && upper.val <= root.val) return false;
        return isValidBSTBound(root.left, lower, root) && isValidBSTBound(root.right, root, upper);
    }
}
