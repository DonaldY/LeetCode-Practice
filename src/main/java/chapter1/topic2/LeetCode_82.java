package chapter1.topic2;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * 题意： 删除重复的节点（自己本身删除）
 *
 * 思路：
 * 1. 记录前一个节点，然后这个节点向后看和他一样的节点
 * 2. 前一个节点的next  总是 当前节点的next
 */
public class LeetCode_82 {

    // Time: o(n), Space: o(1), Faster: 79.57%
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = prev.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            // update prev
            if (prev.next != cur) prev.next = cur.next;
            else prev = prev.next;
            // update cur
            cur = prev.next;
        }
        return dummy.next;
    }
}
