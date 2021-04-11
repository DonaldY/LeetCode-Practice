package chapter1.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author donald
 * @date 2020/6/12
 *
 * 116. Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node,
 * just like in Figure B. The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 *
 *
 * 题意：
 * 给你一棵满二叉树，每个树节点额外增加一个 next 指针，指向它右边的节点。
 * 一开始所有节点的 next 指针都为空，你要写一个函数处理这棵二叉树，使得所有节点的 next 指针都指向正确的节点。
 *
 * 注意，满二叉树中，所有叶子节点都在最后一层。并且除了叶子节点，所有其他节点都有两个子节点。
 *
 * 思路：
 * 1. BFS，用一个队列记住每层长度，然后确定关系
 * 2. 利用满二叉树特性，直接操作
 * 3. 递归方法
 * 4. 遍历方法
 */
public class LeetCode_116 {

    class Node {
        public int val;
        public Node left, right, next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time: O(n), Space: O(n), Faster: 53.13%
    public Node connectBFS(Node root) {

        if (null == root) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node preNode = queue.poll();
            int size = queue.size();

            if (preNode.left != null) queue.add(preNode.left);
            if (preNode.right != null) queue.add(preNode.right);

            while (size > 0) {
                Node node = queue.poll();
                preNode.next = node;
                preNode = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                --size;
            }
        }
        return root;
    }

    // Time: O(n), Space: O(log(n)), Faster: 100%
    public Node connectRecursive(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }

    // Time: O(n), Space: O(1), Faster: 100%
    public Node connectIterative(Node root) {
        if (root == null) return null;
        Node leftMost = root, p;
        while (leftMost.left != null) {
            p = leftMost;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null)
                    p.right.next = p.next.left;
                p = p.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
