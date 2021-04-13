package chapter4.topic4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author donald
 * @date 2021/04/13
 *
 * 783. 二叉搜索树节点最小距离
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * ```
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * ```
 *
 * 题意： 求任意两节点的最小值
 *
 * 思路：
 * 前序遍历每个结点，根据搜索树的特性找到当前结点左子树最大值和右子树最小值，用当前结点的值分别和找到的两个值做差，取最小即可。
 *
 * Tips: 差值最小是相邻的节点
 */
public class LeetCode_783 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time: O(n), Space: O(h), Faster:
    public int minDiffInBST(TreeNode root) {

        if (null == root) return 0;

        int min = Integer.MAX_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (null != node.left) {
                min = Math.min(min, Math.abs(node.val - node.left.val));
                queue.add(node.left);
            }
            if (null != node.right) {
                min = Math.min(min, Math.abs(node.val - node.right.val));
                queue.add(node.right);
            }

        }

        return min;
    }

    int pre;
    int ans;
    // Time: O(n), Space: O(h), Faster: 100.00%
    public int minDiffInBST2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
