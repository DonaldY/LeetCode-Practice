package chapter1.topic3;

import java.util.Stack;

/**
 * @author donald
 * @date 2022/10/10
 *
 * 思路：
 * 1. 栈：先计数 n、再走 n/2 步， 入栈保存
 */
public class LeetCode_143 {

    public static void main(String[] args) {

        LeetCode_143 leetCode_143 = new LeetCode_143();
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);head.next = p1;
        ListNode p2 = new ListNode(3);p1.next = p2;
        ListNode p3 = new ListNode(4);p2.next = p3;
        ListNode p4 = new ListNode(5);p3.next = p4;
        leetCode_143.reorderList(head);
    }

    // Time: O(n), Space: O(n), Faster: 15.74%
    public void reorderList(ListNode head) {
        if (null == head || null == head.next) return;

        // 1. 计数
        int cnt = 0;
        for (ListNode node = head; node != null; node = node.next) ++cnt;

        // 2. 先走 (n / 2) + 1 步
        Stack<ListNode> stack = new Stack<>();
        ListNode next = head;
        for (int i = cnt / 2; i > 0; --i) next = next.next;
        ListNode pre = next;
        next = next.next;
        pre.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = null;
            stack.push(next);
            next = tmp;
        }

        // 3. 组合
        ListNode cur = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            ListNode tmp = cur.next;
            cur.next = node;
            node.next = tmp;

            cur = tmp;
        }
    }
}
