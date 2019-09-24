package chapter1.topic2;

/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * 题意：
 * 给你一个单链表和一个数字，你要把小于这个数字的节点都移到链表前面，大于等于这个数字的节点都移到链表后面。
 * 并且在较小和较大的这两堆节点中，节点之间的相对顺序保持不变。
 *
 * 思路：
 * 1. 两个链表
 *    smaller： 比 x 小，串成一个链表
 *    greater： 比 x 大，串成一个链表
 *
 * Tips： 有多个 x
 *
 */
public class LeetCode_86 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        ListNode smaller = new ListNode(0), greater = new ListNode(0);
        ListNode p = smaller, q = greater, tmp = head;

        while (tmp != null) {

            if (tmp.val < x) {

                p.next = tmp;
                p = p.next;
            } else {

                q.next = tmp;
                q = q.next;
            }

            tmp = tmp.next;
        }

        p.next = greater.next;
        q.next = null;

        return smaller.next;
    }
}
