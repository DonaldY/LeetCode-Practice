package chapter1.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 题意： 将二叉树变成链表, 无左子树, 均有右子树
 *
 * 思路：
 * 1. 前序遍历将树放入队列中，然后取出赋值
 * 2. 一边做前序遍历，一边做二叉树(右左根)
 *
 */
public class LeetCode_114 {

    // Time: O(n), Space: O(n), Faster: 68.72%
    public void flatten(TreeNode root) {

        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();

        preOrderTraversal(root, queue);

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();
            treeNode.left = null;
            treeNode.right = null;
            if (!queue.isEmpty()) treeNode.right = queue.peek();
        }
    }

    private void preOrderTraversal(TreeNode root, Queue<TreeNode> queue) {

        if (root == null) return;

        queue.add(root);
        preOrderTraversal(root.left, queue);
        preOrderTraversal(root.right, queue);
    }


    private TreeNode prev = null;

    // Time: O(n), Space: O(n), Faster: 100.00%
    public void flattenReversePreorder(TreeNode root) {
        if (root == null) return;
        flattenReversePreorder(root.right);
        flattenReversePreorder(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
