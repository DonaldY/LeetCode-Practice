package chapter1.topic3;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 * 题意：
 * 返回链表的深度拷贝
 *
 * 思路：
 * 1. 把所有节点都保存下来，然后再逐个创建
 * 2. 更
 */
public class LeetCode_138 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    // Time: o(n), Space: o(n), Faster: 99.80%
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node s = head;

        HashMap<Node, Node> map = new HashMap<>();

        while (s != null) {

            map.put(s, new Node(s.val, null, null));

            s = s.next;
        }

        s = head;

        while (s != null) {

            Node temp = map.get(s);

            Node next = map.get(s.next);

            Node random = map.get(s.random);

            temp.next = next;
            temp.random = random;

            s = s.next;
        }

        return map.get(head);
    }
}
