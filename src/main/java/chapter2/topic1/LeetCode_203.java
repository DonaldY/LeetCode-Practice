package chapter2.topic1;

/**
 * 203. Remove Linked List Elements
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * 题意： 删除所有节点上选中的节点
 *
 * 思路：
 * 1. 双指针
 */
public class LeetCode_203 {

    // Time: o(n), Space: o(1), Faster: 98.63%
    public ListNode removeElements(ListNode head, int val) {

        ListNode pre = head, pointer = head;

        while (pointer != null) {

            if (pointer.val == val) {

                if (pointer.val == head.val) {

                    head = pointer.next;

                } else {

                    ListNode temp = pointer.next;
                    pre.next = temp;
                    pointer.next = null;
                    pointer = temp;
                    continue;
                }
            }

            pre = pointer;
            pointer = pointer.next;
        }

        return head;
    }

    // Time: O(n), Space: O(1)
    public ListNode remove(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode notEqual = dummy;

        while (notEqual.next != null) {
            if (notEqual.next.val == val) notEqual.next = notEqual.next.next;
            else notEqual = notEqual.next;
        }
        return dummy.next;
    }
}
