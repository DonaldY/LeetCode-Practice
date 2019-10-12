package chapter3.topic3;

import java.util.Stack;

/**
 * 538. Convert BST to Greater Tree
 *
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 *
 * 题意： 二叉搜索树， 每个节点加上当前最大值
 *
 * 树中序遍历： 2   5   13
 * 则加完后：  20  18   13
 *
 * 思路： 从右往左处理，逐渐累加
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LeetCode_538 {

    // Time: O(n), Space: O(n), Faster: 99.95%
    public TreeNode convertBST(TreeNode root) {

        if (root == null) return root;

        traverse(root, 0);

        return root;
    }

    private int traverse(TreeNode root, int sum) {

        if (root == null) return sum;

        int cur = traverse(root.right, sum);
        root.val += cur;
        return traverse(root.left, root.val);
    }

    // Time: O(n), Space: O(n)
    public TreeNode convertBSTIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        int sum = 0;

        while (cur != null || !st.empty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.right;
            }
            cur = st.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }
}
