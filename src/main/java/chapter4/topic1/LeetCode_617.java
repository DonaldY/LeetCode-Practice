package chapter4.topic1;

/**
 * 617. Merge Two Binary Trees
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 题意： 合并两看两颗树，两个树对应节点都有则相加，若没有则添加那个节点
 *
 *
 * 思路：
 * 1. 逐一比较
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_617 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        TreeNode node;

        if (t1 != null && t2 != null) {

            node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
        } else if (t1 != null) {

            node = t1;
        } else if (t2 != null) {

            node = t2;
        } else {

            return null;
        }

        return node;
    }
}
