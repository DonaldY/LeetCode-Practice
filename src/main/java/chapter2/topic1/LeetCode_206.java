package chapter2.topic1;

import java.util.List;
import java.util.Stack;

/**
 * 206. Reverse Linked List
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * 题意：反转链表
 *
 * 1.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode_206 {

    public static void main(String[] args) {

        ListNode node1 = initNode();

        LeetCode_206 leetCode = new LeetCode_206();
        ListNode node = leetCode.reverseList(node1);

        while (node != null) {

            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode initNode() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        return node1;
    }

    // Time: o(n) Space: o(n) faster: 5%
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;

        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode node = head;

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode reverseHead = stack.pop();
        ListNode preNode = reverseHead;
        reverseHead.next = null;
        while (!stack.isEmpty()) {

            ListNode tempNode = stack.pop();
            preNode.next = tempNode;
            preNode = tempNode;
        }

        head.next = null;

        return reverseHead;
    }

}
