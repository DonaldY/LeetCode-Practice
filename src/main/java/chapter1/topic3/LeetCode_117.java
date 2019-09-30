package chapter1.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * 题意： 把节点的 next 指针指向其右边的节点，若无右边的节点则设置为null
 *
 * 思路：
 * 1. BFS, 把每一层排出来, 慢慢处理
 */
public class LeetCode_117 {

    // Time: O(n), Space: O(n), Faster: 41.10%
    public Node connect(Node root) {

        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            Node node = queue.poll();

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            for (int i = 1; i < size; ++i) {

                Node next = queue.poll();

                node.next = next;

                node = next;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
