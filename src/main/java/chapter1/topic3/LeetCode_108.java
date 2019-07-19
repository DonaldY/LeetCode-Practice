package chapter1.topic3;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 题意： 给一个已排序的数组，使其变成二叉搜索树
 *
 * 思路：
 * 1. 直接生成插入（可适用于无序）
 * 2. 从中间开始生成树根，两边生成节点（递归）
 */
public class LeetCode_108 {

    // Time: o(log(n)), Space: o(n), Faster: 100.00%
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {

        if (high < low) return null;

        int mid = (low + high + 1) / 2;

        int val = nums[mid];

        TreeNode node = new TreeNode(val);
        node.left = buildTree(nums, low, mid - 1);
        node.right = buildTree(nums, mid + 1, high);

        return node;
    }
}
