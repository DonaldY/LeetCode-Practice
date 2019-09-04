package bytedance.linkedlist;

/**
 * 反转链表
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 题意： 反转链表
 *
 * 思路：
 * 1. 递归
 * 2. 迭代
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        return null;
    }

    // Time: o(n), Space: o(n)
    public ListNode reverseListWithRecursive(ListNode head) {

        ListNode node = new ListNode(0);

        reverseRecursive(null, head, node);

        return node.next;
    }

    private void reverseRecursive(ListNode preNode, ListNode node, ListNode result) {

        if (node == null) {

            result.next = preNode;

            return;
        }

        ListNode nextNode = node.next;

        node.next = preNode;

        reverseRecursive(node, nextNode, result);
    }

    // Time: o(n), Space:L o(1)
    public ListNode reverseListWithIteration(ListNode head) {

        ListNode node = head, preNode = null, nextNode = null;

        ListNode result = head;

        while (node != null) {

            nextNode = node.next;

            node.next = preNode;

            preNode = node;

            node = nextNode;

            if (node == null) result = preNode;
        }

        return result;
    }
}
