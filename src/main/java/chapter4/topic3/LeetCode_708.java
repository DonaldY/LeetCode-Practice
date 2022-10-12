package chapter4.topic3;

import chapter2.topic4.LeetCode_369;

/**
 * @author donald
 * @date 2022/10/12
 */
public class LeetCode_708 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (null == head) {   // 特殊栗子： 空节点
            node.next = node;
            return node;
        }
        if (head.next == head) { // 特殊栗子： 只有一个节点，next指针指向自己
            head.next = node;
            node.next = head;
            return head;
        }

        Node cur = head, next = head.next;
        // 不为循环
        while (next != head) {
            // 找到合适的位置
            if (insertVal >= cur.val && insertVal <= next.val) {
                break;
            }
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }
        // 构建链表
        cur.next = node;
        node.next = next;
        return head;
    }
}
