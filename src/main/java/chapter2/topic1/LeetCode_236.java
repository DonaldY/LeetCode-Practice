package chapter2.topic1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 *
 * 题意： 找到两个节点的最小父节点
 *
 * 思路：
 * 1. 将p和q的父节点均保存下来，然后逐一比对
 * 2.
 */
public class LeetCode_236 {

    // Time: O(n), Time: O(n), Faster: 23.04%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        findTreeNode(root, p, queueP);
        findTreeNode(root, q, queueQ);

        while (queueP.size() > queueQ.size()) queueP.poll();
        while (queueP.size() < queueQ.size()) queueQ.poll();

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {

            TreeNode pNode = queueP.poll();
            TreeNode qNode = queueQ.poll();

            if (pNode == qNode) return pNode;
        }

        return null;
    }

    private TreeNode findTreeNode(TreeNode root, TreeNode p, Queue<TreeNode> queue) {

        if (root == null) return null;

        if (root == p) {

            queue.add(p);
            return p;
        }

        TreeNode targetNode = findTreeNode(root.left, p, queue);

        if (targetNode == p) {

            queue.add(root);
            return targetNode;
        }

        targetNode = findTreeNode(root.right, p, queue);

        if (targetNode == p) {

            queue.add(root);
            return targetNode;
        }

        return null;
    }

    // Time:O(n), Space:O(n), Faster: 71.07%
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);

        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if(left != null && right != null) return root;
        if(left != null) return left;

        return right;
    }
}
