package chapter1.topic3;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 *
 * 题意： 给一棵树，给出其前序遍历
 *
 * 题意： 按思路输出
 */
public class LeetCode_144 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        buildPreOrderList(root, result);

        return result;
    }

    private void buildPreOrderList(TreeNode root, List<Integer> result) {

        if (root == null) return;

        result.add(root.val);

        if (root.left != null) buildPreOrderList(root.left, result);
        if (root.right != null) buildPreOrderList(root.right, result);
    }
}
