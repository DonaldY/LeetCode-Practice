package chapter3.topic3;

import java.util.*;

/**
 * @author donald
 * @date 2022/10/13
 *
 * 思路：
 * 1. BFS队列
 */
public class LeetCode_515 {

    // Time: O(n), Space: O(n), Faster: 84.58%
    public List<Integer> largestValues(TreeNode root) {
        if (null == root) return Collections.emptyList(); // 特殊用例
        List<Integer> result = new ArrayList<>();

        // 标准的 BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
            result.add(max);  // 记录结果
        }
        return result;
    }
}
