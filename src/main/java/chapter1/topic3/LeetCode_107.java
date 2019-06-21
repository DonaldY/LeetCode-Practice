package chapter1.topic3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 题意： 逆序层级
 *
 * 思路：
 * 1. 入栈，记录每一层个数，出栈成数组，输出
 *    按层级输出的思路，最后逆序交换下即可
 */

public class LeetCode_107 {

    // Time: o(n), Space: o(n), faster: 92.65%
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (null == root) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> elem = new ArrayList<>();

            int size = queue.size(); // 每一层大小

            for (int i = 0; i < size; ++i) {

                TreeNode s = queue.poll();
                elem.add(s.val);
                if (s.left != null) queue.add(s.left);
                if (s.right != null) queue.add(s.right);

            }

            result.add(elem);
        }

        for (int i = 0; i < result.size() / 2; ++i) {

            List<Integer> tempList;

            int inverseIndex = result.size() - 1 - i;

            tempList = result.get(i);
            result.set(i, result.get(inverseIndex));
            result.set(inverseIndex, tempList);
        }

        return result;
    }
}
