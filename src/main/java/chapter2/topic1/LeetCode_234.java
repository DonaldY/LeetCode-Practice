package chapter2.topic1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 234. Palindrome Linked List
 *
 * Input: 1->2
 * Output: false
 *
 * Input: 1->2->2->1
 * Output: true
 *
 * 题意： 判断链表是否回文
 *
 * 思路：
 * 1. 遍历一遍，记录在数组然后进行比较
 * 2. 用栈来存放，然后再逐一对比
 * 3. 反转前半部分链表，然后对比
 */
public class LeetCode_234 {

    // 方法一：
    // Time: o(n) Space: o(n) faster: 21.12%
    public boolean isPalindrome(ListNode head) {

        if (null == head) return true;

        ListNode node = head;

        List<Integer> nums = new ArrayList<Integer>();

        while (node != null) {

            nums.add(node.val);

            node = node.next;
        }

        for (int i = 0, j = nums.size() - 1 ; i < nums.size() / 2 && j >= nums.size() / 2; ++i, --j) {

            if (!nums.get(i).equals(nums.get(j))) return false;
        }

        return true;
    }

    // 方法二：
    // Time: O(n), Space: O(n) faster: 13.56%
    public boolean isPalindromeUsingStack(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        for (ListNode p = head; p != null; p = p.next)
            s.push(p.val);

        for (ListNode p = head; p != null; p = p.next)
            if (p.val != s.pop())
                return false;

        return true;
    }

    // 方法三：
    // Time: O(n), Space: O(1) faster:98.72%
    public boolean isPalindromeReverseList(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next, ++len);

        // reverse half list
        ListNode cur = head, pre = null;
        for (int i = 0; i < len / 2; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 奇数，跳过当前
        if (len % 2 == 1) cur = cur.next;
        for (; pre != null && cur != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val) return false;
        }
        return true;
    }
}
