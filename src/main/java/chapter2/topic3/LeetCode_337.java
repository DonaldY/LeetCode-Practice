package chapter2.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2021/02/09
 *
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 题意：
 *
 * 思路：
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_337 {

    Map<TreeNode, Integer> memo = new HashMap<>();

    // Time: O(n), Space: O(n), Faster: 57.62%
    int rob(TreeNode root) {

        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 取，然后去下下家做选择
        int doIt = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        // 不取，然后去下家做选择
        int notDo = rob(root.left) + rob(root.right);
        // 选择收益更大的
        int res = Math.max(doIt, notDo);
        memo.put(root, res);
        return res;
    }
}
