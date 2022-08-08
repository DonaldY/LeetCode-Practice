package chapter1.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2022/08/08
 *
 * 二叉树的右视图
 *
 * 这个题目说的是，给你一棵二叉树，并且你站在这棵树的右边，你要返回从上到下看到的节点值。
 * 比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     4
 *  / \
 * 6   8
 *
 * 站在这棵二叉树的右边看过来，从上到下看到的数字依次是：
 *
 * [1, 4, 8]
 *
 * 思路：
 * 1. BFS： 层序遍历即可，右边数字
 * 2. DFS
 */
public class LeetCode_199 {

    // 方法一： BFS
    // Time: O(n), Space: O(n), Faster: 82.03%
    public List<Integer> rightSideViewBFS(TreeNode root) {
        if (null == root) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            while (size-- > 0) {
                node = queue.poll();
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

    // 方法二：DFS
    // Time: O(n), Space: O(n), Faster: 100.00%
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;
        if (level == result.size()) result.add(root.val);
        dfs(root.right, result, level+1);
        dfs(root.left, result, level+1);
    }
}
