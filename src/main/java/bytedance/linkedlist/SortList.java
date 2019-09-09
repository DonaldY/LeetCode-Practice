package bytedance.linkedlist;

/**
 * 链表与树 - 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 题意: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 思路:
 * 1. 把数取出来, 再进行排序, 再赋值
 *
 * 1. 快速排序
 * 2. 归并排序
 *    利用快慢指针找到中间节点
 *    再合并两个链表
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        return null;
    }

    // Time: o(n*log(n)), Space: o(n)
    public ListNode quickSortList(ListNode head) {

        this.quickSort(head, null);
        return head;
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

    private void swap(ListNode a, ListNode b) {

        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    // Time: o(n * log(n)), Space: o(log(n))
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
