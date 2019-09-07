package bytedance.linkedlist;

/**
 * 链表与树 - 合并两个有序链表
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 题意: 合并新链表
 *
 * 思路: 判断比较
 */
public class MergeTwoLists {

    // Time: o(max(n, m)), Space: o(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummp = new ListNode(0), curr = dummp;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {

                curr.next = l1;
                l1 = l1.next;
            } else {

                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummp.next;
    }
}
