package chapter1.topic3;

/**
 * 148. Sort List
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
 * 题意： 单链表排序
 *
 * 思路：
 * 1. 先生成数组，再排序，然后生成链表
 * 2. 丢入最小堆里，然后再生成
 * 3. 类比快速排序
 * 4. 归并排序
 */
public class LeetCode_148 {

    public ListNode sortList(ListNode head) {

        return null;
    }

    private void swap(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) return;
        int pivot = head.val;
        ListNode slow = head, fast = head.next;
        while (fast != end) {
            if (fast.val <= pivot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, end);
    }

    // Time: O(n*log(n)), Space: O(n), Faster: 6.60%
    public ListNode quickSortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    // Time: O(n*log(n)), Space: O(log(n)), Faster: 97.67%
    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = mergeSortList(slow.next);
        slow.next = null;
        ListNode left = mergeSortList(head);
        return mergeTwoSortedLists(left, right);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }
}
