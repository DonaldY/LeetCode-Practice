package chapter1.topic2;

/**
 * 61. Rotate List
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * 题意： 旋转链表 k 个数字。
 * 跟之前一个旋转数组的有点像
 *
 * 思路： 记录位置，旋转
 *       1. 找到分割点，分割成两个链表
 *       2. 合成一个链表
 */
public class LeetCode_61 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;

        int cnt = 0;

        for (ListNode p = head; p != null; p = p.next) ++cnt;

        k = k % cnt;

        if (cnt == 1 || k == 0) return head;

        ListNode q = head, pre = head;
        for (int i = cnt - k; i > 0 && q != null; --i) {

            pre = q;
            q = q.next;
        }

        pre.next = null;

        ListNode s = q;
        while (s != null && s.next != null) s = s.next;

        s.next = head;

        return q;
    }
}
