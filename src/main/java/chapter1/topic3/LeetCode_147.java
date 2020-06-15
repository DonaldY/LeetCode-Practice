package chapter1.topic3;

/**
 * @author donald
 * @date 2020/6/13
 *
 * 147. Insertion Sort List
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * 题意：
 * 给你一个单链表，你要使用插入排序算法对它进行排序。
 *
 * 思路：
 * 1. 直接插入排序
 *    1.1 在原数组上排序
 *    1.2 在另外数组上排序
 */
public class LeetCode_147 {

    // Time: O(n^2), Space: O(1), Faster: 5.45%
    public ListNode insertionSortList(ListNode head) {

        if (null == head) return head;

        ListNode p = head;

        while (p != null) {

            ListNode q = p.next;

            while (q != null) {

                if (q.val < p.val) {

                    int tmp = q.val;
                    q.val = p.val;
                    p.val = tmp;
                }

                q = q.next;
            }

            p = p.next;
        }

        return head;
    }

    // Time: O(n^2), Space: O(1)
    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0), p;
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            p = dummy;
            while (p.next != null && cur.val >= p.next.val)
                p = p.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    // Time: O(n^2), Space: O(1), Faster: 98.70%
    public ListNode insertionSortListFast(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy;
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            if (p.next != null && cur.val < p.next.val) p = dummy;
            while (p.next != null && cur.val >= p.next.val)
                p = p.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
