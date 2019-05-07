package chapter1.topic3;

/**
 * 101. Symmetric Tree
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3

 * 题意： 判断二叉树是否对称
 *
 * 1. 每一层进行比较（回文比较）
 *    BFS 可以拿到按层级拿取节点
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_101 {

    public static void main(String[] args) {

        TreeNode tree1 = initTree1();
        TreeNode tree2 = initTree2();

        LeetCode_101 leetCode = new LeetCode_101();
        System.out.println(leetCode.isSymmetric(tree1));

        System.out.println(leetCode.isSymmetric(tree2));
    }

    private static TreeNode initTree1() {

        TreeNode node31 = getNode(3, null, null);
        TreeNode node32 = getNode(4, null, null);
        TreeNode node33 = getNode(4, null, null);
        TreeNode node34 = getNode(3, null, null);
        TreeNode node21 = getNode(2, node31, node32);
        TreeNode node22 = getNode(2, node33, node34);

        return getNode(1, node21, node22);
    }

    private static TreeNode initTree2() {

        TreeNode node32 = getNode(4, null, null);
        TreeNode node34 = getNode(3, null, null);
        TreeNode node21 = getNode(2, null, node32);
        TreeNode node22 = getNode(2, null, node34);

        return getNode(1, node21, node22);
    }

    private static TreeNode getNode(int val, TreeNode node1, TreeNode node2) {

        TreeNode node = new TreeNode(val);
        node.left = node1;
        node.right = node2;

        return node;
    }

    // Time o(n), Space o(n)
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSymmetricNode(root.left, root.right);
    }

    private boolean isSymmetricNode(TreeNode left, TreeNode right) {

        if (left != null && right != null) {

            if (left.val != right.val) return false;

            return isSymmetricNode(left.left, right.right) && isSymmetricNode(left.right , right.left);
        }

        return left == null && right == null;
    }
}
