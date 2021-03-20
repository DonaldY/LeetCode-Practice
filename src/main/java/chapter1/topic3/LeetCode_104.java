package chapter1.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * 题意：最大树的深度
 *
 * 思路：
 * 1. 递归
 *    - 节点为null
 *    - 左节点不为null
 *    - 右节点不为null
 *    - 左右节点为null + 1
 * 2. 队列, 层序遍历
 *    记录每一次的个数，然后出队相应的个数
 */
public class LeetCode_104 {

    public static void main(String[] args) {


    }

    // Time: O(n), Space: (n)， Faster：100%
    public int maxDepthWithRecursive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthWithRecursive(root.left), maxDepthWithRecursive(root.right)) + 1;
    }

    // Time: O(n), Space: (n)， Faster：11.57%
    public int maxDepthWithQueue(TreeNode root) {

        if (root == null) return 0;

        int maxDepth = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; ++i) {

                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            ++maxDepth;
        }

        return maxDepth;
    }
}
