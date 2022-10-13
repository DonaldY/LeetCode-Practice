package chapter3.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/10/13
 *
 * 思路： BFS
 */
public class LeetCode_513 {

    // Time: O(n), Space: O(n), Faster: 70.22%
    public int findBottomLeftValue(TreeNode root) {
        int leftNum = -1;
        // 标准的 BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftNum = queue.peek().val;  // 记录每一层最左边的数
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
        }
        return leftNum;
    }
}
