package chapter1.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 题意：根据中序和后序，构建一颗二叉树
 *
 * 思路：
 * 1. 根据后序找根，再在中序分组
 */
public class LeetCode_106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Time: o(n), Space: o(n), Faster: 66.41%
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inPos = new HashMap<>();

        for (int i = 0; i < inorder.length; ++i)
            inPos.put(inorder[i], i);

        return buildTree(postorder, 0, postorder.length - 1, 0, inPos);
    }

    private TreeNode buildTree(int[] post, int postStart, int postEnd, int inStart, Map<Integer, Integer> inPos) {

        if (postStart > postEnd) return null;

        TreeNode root = new TreeNode(post[postEnd]);
        int rootIdx = inPos.get(post[postEnd]);
        int leftLen = rootIdx - inStart;
        root.left = buildTree(post, postStart, postStart + leftLen - 1, inStart, inPos);
        root.right = buildTree(post, postStart + leftLen, postEnd - 1, rootIdx + 1, inPos);

        return root;
    }
}
