package chapter2.topic1;

/**
 * 206. Reverse Linked List
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * 题意：反转链表
 *
 * 1. 借助栈
 * 2. 直接反转
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode_206 {

    // Time: o(n) Space: o(1) faster: 100%
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;

    }

}
