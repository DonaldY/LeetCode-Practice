package chapter1.topic3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/10/13
 */
public class LeetCode_129 {
    // Time: O(n), Space: O(n), Faster: 16.54%
    public int sumNumbers(TreeNode root) {
        if (null == root) return 0;

        // 1. DFS： 递归、回溯（决策树）
        List<Integer> result = new ArrayList<>();
        dfs(root, result, new StringBuilder());

        // 2. 求和
        int sum = 0;
        for (Integer num : result) sum += num;
        return sum;
    }

    private void dfs(TreeNode root, List<Integer> result, StringBuilder sb) {
        if (null == root) { // 边界问题
            return;
        }

        sb.append(root.val);

        if (null == root.left && null == root.right) {
            int num = Integer.parseInt(sb.toString());
            result.add(num);
        }

        if (null != root.left) dfs(root.left, result, sb);
        if (null != root.right) dfs(root.right, result, sb);

        // 回溯：
        sb.deleteCharAt(sb.length() - 1); // 因为 0 <= val <= 9
    }

    // LeetCode 解法，比较精简
    // Time: O(n), Space: O(n), Faster: 100.00%
    public int sumNumbersL(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
