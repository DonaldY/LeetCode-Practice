package chapter3.topic1;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * 题意： 在树中找到求和后，值相等的.
 * 其中，路径不需要开始于根节点，或结束于叶子节点。但必须是从父节点到子节点。
 *
 * 思路：
 * 1. 每一个节点往下的分支都需要查找
 *
 * 3. 哈希表记录前缀路径和
 */
public class LeetCode_437 {

    // Time: O(n ^ 2), Space: O(n ^ 2), Faster: 52.72%
    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        return traverse(root, sum);
    }

    private int traverse(TreeNode root, int sum) {

        if (root == null) return 0;

        int result = findPath(root, 0, sum);

        result += traverse(root.left, sum);
        result += traverse(root.right, sum);

        return result;
    }

    private int findPath(TreeNode root, long num, long sum) { // long： 防溢可能

        if (root == null) return 0;

        num += root.val;

        int result = 0;

        if (num == sum) ++result;

        result += findPath(root.left, num, sum);
        result += findPath(root.right, num, sum);

        return result;
    }

    // Time: O(n^2), Space: O(n), Faster: 52.72%
    public int pathSumRecursive(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathFrom(root, sum) +
                pathSumRecursive(root.left, sum) +
                pathSumRecursive(root.right, sum);
    }

    private int pathFrom(TreeNode root, long sum) {  // long： 防溢可能
        if (root == null) return 0;
        int cnt = 0;
        if (root.val == sum) ++cnt;
        cnt += pathFrom(root.left, sum - root.val);
        cnt += pathFrom(root.right, sum - root.val);
        return cnt;
    }

    // 前缀和计算
    // Time: O(n), Space: O(n), Faster: 95.86%
    public int pathSumPrefixSum(TreeNode root, int sum) {
        Map<Long, Integer> prefixSum = new HashMap<>();   // long： 防溢可能
        prefixSum.put(0L, 1);
        return dfs(root, 0, sum, prefixSum);
    }

    private int dfs(TreeNode root, long cur, long sum,
                    Map<Long, Integer> prefixSum) { // long： 防溢可能
        if (root == null) return 0;
        cur += root.val;
        int cnt = prefixSum.getOrDefault(cur - sum, 0);
        prefixSum.put(cur, prefixSum.getOrDefault(cur, 0) + 1);
        cnt += dfs(root.left, cur, sum, prefixSum);
        cnt += dfs(root.right, cur, sum, prefixSum);
        prefixSum.put(cur, prefixSum.get(cur) - 1); // 回溯，左子树的计算不能用于右子树
        return cnt;
    }
}
