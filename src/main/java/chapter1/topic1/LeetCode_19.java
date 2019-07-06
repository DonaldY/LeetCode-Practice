package chapter1.topic1;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * 题意：移除倒数第n个数
 *
 * 思路：
 * 1. 先求得总个数，再遍历查找
 * 2. 有头节点，进行查找
 *    p 先走n步， q不走
 *    p 再走到底， q跟随p一起移动
 */
public class LeetCode_19 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return head;

        int totalNum = 0;

        ListNode node = head;

        while (node != null) {

            ++ totalNum;

            node = node.next;
        }

        int num = totalNum - n;

        node = head;

        if (num == 0) {

            head = head.next;
            return head;
        }

        --num;

        while (num > 0) {

            node = node.next;
            --num;
        }

        node.next = node.next.next;

        return head;
    }

    // Time: O(k), Space: O(1)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q = dummy;

        for (; n > 0 && q.next != null; --n) q = q.next;
        if (n != 0) return dummy.next;

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

}
