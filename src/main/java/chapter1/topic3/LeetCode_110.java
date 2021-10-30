package chapter1.topic3;

/**
 * 110. Balanced Binary Tree
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * 题意：平衡二叉树
 * <p>
 * 思路：
 * 1. 递归比较根节点左右子树的高度
 * 2. 从根节点查找
 */
public class LeetCode_110 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(5)),
                                new TreeNode(4)),
                        new TreeNode(3, new TreeNode(4), new TreeNode(4))),
                new TreeNode(2,
                        new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)));

        System.out.println(isBalancedTreeTopDown(root));
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        return true;
    }

    // Time: o(nlog(n)), Space: o(n), Faster: 91.57%
    public static boolean isBalancedTreeTopDown(TreeNode root) {

        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                && isBalancedTreeTopDown(root.left) && isBalancedTreeTopDown(root.right);
    }

    private static int getHeight(TreeNode node) {

        if (node == null) return 0;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Time: o(n), Space: o(n), Faster: 91.57%
    public static boolean isBalancedTreeBottomUp(TreeNode node) {
        return getHeightAndCheck(node) != -1;
    }

    public static int getHeightAndCheck(TreeNode root) {

        if (root == null) return 0;

        int left = getHeightAndCheck(root.left);
        if (left == -1) return -1;

        int right = getHeightAndCheck(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
