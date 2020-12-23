package chapter1.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 * 题意：最小深度，根节点到最近叶子节点的距离
 *
 * 思路：
 * 1. 递归
 *    - 根节点为 null， 返回 0
 *    - 节点的左右子树为 null， 返回1
 *    - 左子树不为null， 返回 递归左子树 + 1
 *    - 右子树不为null， 返回 递归右子树 + 1
 *    - 左右子树都不为null， 返回 左右子树最小 + 1
 *
 * 2. 层级遍历
 *    用数量来判断每一层的节点个数
 */

public class LeetCode_111 {

    public static void main(String[] args) {


    }

    // Time: o(n) Space: o(n) faster: 100%
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left != null && root.right != null) {

            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

        if (root.left != null) return minDepth(root.left) + 1;

        return minDepth(root.right) + 1;
    }

    // Time: o(n) Space: o(n), Faster: 80.09%
    public int minDepthWith(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; ++i) {

                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) return depth;

                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);
            }

            ++depth;
        }

        return -1;
    }
}
