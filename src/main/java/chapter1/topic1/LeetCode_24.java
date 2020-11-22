package chapter1.topic1;

/**
 * @author donald
 * @date 2020/11/22
 *
 * Leetcode 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 思路：
 * 类似 Leetcode 206那题，只是步长为1,区间为2
 * Tips: 单个元素时候
 */
public class LeetCode_24 {

    // Time: O(n), Space:O(1), Faster: 100.00%
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode curr = head, dummp = new ListNode(0), pre = dummp;

        while (curr != null) {

            if (curr.next == null) break;

            ListNode start = curr, end = curr.next;
            curr = end.next;

            end.next = start;

            pre.next = end;
            pre = start;
            start.next = curr;
        }

        return dummp.next;
    }
}
