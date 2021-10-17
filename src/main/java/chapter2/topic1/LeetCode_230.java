package chapter2.topic1;

/**
 * @author donald
 * @date 2021/10/17
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. Kth Smallest Element in a BST
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * ```
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * ```
 *
 * 二叉搜索树具有如下性质：
 *    - 结点的左子树只包含小于当前结点的数。
 *    - 结点的右子树只包含大于当前结点的数。
 *    - 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 方法一： 中序遍历
 */
public class LeetCode_230 {

    // Time: O(H+k), Space: O(n), Faster: 37.14%
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 一直遍历左子树
            // 左子树最小
            // 找到最小值
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
