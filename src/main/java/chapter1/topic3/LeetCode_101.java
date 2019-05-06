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
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题意： 判断二叉树是否对称
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_101 {

    public boolean isSymmetric(TreeNode root) {

        List<Integer> values = new ArrayList<Integer>();

        TreeNode node = root;

        while (node != null) {

            values.add(node.val);

            if (node.left != null) {

                values.add(node.left.val);
            }

            if (node.right != null) {

                values.add(node.right.val);
            }
        }

        return true;
    }
}
