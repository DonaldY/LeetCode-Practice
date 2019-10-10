package chapter2.topic1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
 * 2. 递归中查找
 *    1. 如果当前节点为空，或者等于目标节点p 或 q，则返回当前节点
 *    2. 否则递归到左右子树上进行处理，返回值分别为 left 和 right
 *    3. 如果 left 和 right 非空，则说明在左右子树上各找到一个节点，于是当前的根节点就是最近公共祖先
 *       如果 left 和 right 只有一个非空，则返回那个非空的节点
 *       如果都为空，就返回空指针
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

    // Time: O(n), Space: O(n)
    public TreeNode lcaWithPath(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        List<TreeNode> qpath = new ArrayList<>();
        search(root, p, ppath);
        search(root, q, qpath);
        int i = 0, len = Math.min(ppath.size(), qpath.size());
        while (i < len && ppath.get(i) == qpath.get(i)) ++i;
        return ppath.get(i-1);
    }

    private boolean search(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean ret = search(root.left, node, path) || search(root.right, node, path);
        if (ret) return true;
        path.remove(path.size()-1);
        return false;
    }

    // Time: O(n), Space: O(n)
    public TreeNode lcaExtend(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lcaExtend(root.left, p, q);
        TreeNode right = lcaExtend(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}
