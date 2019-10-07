package chapter1.topic3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 题意： 找到所有路径和等于给定数值的集合
 *
 * 思路：
 * 1. 递归，回溯
 *
 * Tips： 节点的值可以重复，所以删除节点需要注意
 */
public class LeetCode_113 {

    // Time:O(), Space: O(), Faster: 100.00%
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        traversal(root, sum, new ArrayList<Integer>(), result);

        return result;
    }

    private void traversal(TreeNode root, int sum, List<Integer> list,
                           List<List<Integer>> result) {

        if (root == null) return;

        list.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {

            result.add(new ArrayList<>(list));
        }

        if (root.left != null) traversal(root.left, sum - root.val, list, result);
        if (root.right != null) traversal(root.right, sum - root.val, list, result);

        list.remove(list.size() - 1);
    }
}
