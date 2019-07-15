package chapter1.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 题意：给出中序 前序遍历的树，构建出二叉树
 *
 * 思路：
 * 1. 从前序开始遍历，找到根节点
 * 2. 再从中序中查找并分为两个数组
 *
 * 第二种思路：
 * 1. 遍历前序的数，然后在中序中查找数
 * 2. 需要辅助map来快速查找
 */
public class LeetCode_105 {

    // Time: o(n), Space: o(n), Faster: 96.84%
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inPos = new HashMap<>();

        for (int i = 0; i < inorder.length; ++i)
            inPos.put(inorder[i], i);

        return buildTree(preorder, 0, preorder.length - 1, 0, inPos);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart, Map<Integer, Integer> inPos) {

        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIdx = inPos.get(pre[preStart]);
        int leftLen = rootIdx - inStart;
        root.left = buildTree(pre, preStart + 1, preStart + leftLen, inStart, inPos);
        root.right = buildTree(pre, preStart + leftLen + 1, preEnd, rootIdx + 1, inPos);

        return root;
    }


}
