package chapter3.topic1;

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
 * 题意： 在树中找到求和后，值相等的
 *
 * 思路：
 * 1. 每一个节点往下的分支都需要查找
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

    private int findPath(TreeNode root, int num, int sum) {

        if (root == null) return 0;

        num += root.val;

        int result = 0;

        if (num == sum) ++result;

        result += findPath(root.left, num, sum);
        result += findPath(root.right, num, sum);

        return result;
    }
}
