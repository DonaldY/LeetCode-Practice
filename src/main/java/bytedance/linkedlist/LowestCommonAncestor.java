package bytedance.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 链表与树 - 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 题意: 找到两个节点最近的父节点
 *
 * 思路:
 * 1. 递归查找目标节点, 将经历的父节点均压入栈中
 *
 * 2. 并查集
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestor {

    public static void main(String[] args) {

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.left = node1; root.right = node2;
        node1.left = node3; node1.right = node4;
        node2.left = node5; node2.right = node6;
        node4.left = node7; node4.right = node8;

        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, node1, node8).val);
    }

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
}
