package chapter3.topic1;

/**
 * @author donald
 * @date 2022/10/12
 *
 * 思路： 递归
 * 先走 child 节点，记录子节点
 */
public class LeetCode_430 {

    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public Node flatten(Node head) {
        if (null == head) return null;
        flattenInner(head);
        return head;
    }
    private Node flattenInner(Node head) {
        Node cur = head, last = null;
        while (cur != null) {
            Node next = cur.next;
            if (null != cur.child) {
                // 1. 构建 主链 和 子链关系
                cur.next = cur.child; // 构建 next 指针
                cur.child.prev = cur; // 构建 prev 指针

                Node lastChildNode = flattenInner(cur.child); // 找到最后一个节点

                // 2. 去掉子链
                cur.child = null;

                // 3. 链接 子链 和 主链关系
                lastChildNode.next = next;
                if (next != null) next.prev = lastChildNode;

                last = lastChildNode; // 重点
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}

