package chapter1.topic3;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * 题意：
 * 找到循环列表的头节点（第一个循环开始点）
 *
 * 思路：
 * 1. 计数法，第一个被访问第二次的节点
 * 2. 快慢指针，1个走1步，1个走2步
 *    - 先第一遍找到相遇点
 *    - 再往回走，找到起始点
 *
 */
public class LeetCode_142 {

    public ListNode detectCycle(ListNode head) {

        return null;
    }

    // Time: O(n), Space: O(n), Faster: 19.62%
    public ListNode startNodeOfCycleHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p != null; p = p.next) {
            if (set.contains(p)) return p;
            set.add(p);
        }
        return null;
    }

    // Time: o(n), Space: o(1), Faster: 100.00%
    public ListNode startNodeOfCycleTwoPointer(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                for (ListNode p = head; p != slow; p = p.next, slow = slow.next);
                return slow;
            }
        }
        return null;
    }
}
