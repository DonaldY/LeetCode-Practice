package chapter1.topic3;

import java.util.*;

/**
 * @author donald
 * @date 2021/03/17
 *
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * ```
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * ```
 *
 * 题意：这个题目说的是，给你一棵二叉树，要求你从根节点到叶子节点一层一层地进行 Z 字形遍历
 * ，也就是先从左向右访问一层节点，然后从右向左访问下一层节点。
 * 以这样的方式交替去访问二叉树上每一层节点，并且将访问的结果以二维数组的形式返回。
 *
 * 思路：
 * 1. BFS： 每遍历一层就改变方向
 */

public class LeetCode_103 {

    // Time: O(n), Space: O(n), Faster: 76.84%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (null == root) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean right2Left = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new ArrayList<>(size);
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                subResult.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
            if (right2Left) Collections.reverse(subResult);
            right2Left = !right2Left;
            result.add(subResult);
        }
        return result;
    }
}
