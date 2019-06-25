package chapter1.topic3;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 题意： 层序遍历，BFS
 *
 * 思路： 入队列，记录每层的数，然后出队列
 */

import java.util.*;

public class LeetCode_102 {

    // Time: o(n), Space: o(n), Faster: 81.28%
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {

            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            int num = queue.size();
            List<Integer> list = new ArrayList<>(num);
            for (int i = 0; i < num; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }
}
