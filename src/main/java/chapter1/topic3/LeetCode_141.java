package chapter1.topic3;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * 思路：
 * 1. 把每一个节点存储下来，每次判断是否存在
 * 2. 头尾指针，进行判断
 * 3. 快慢指针
 *    若快指针超过慢指针则有环
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LeetCode_141 {

    public boolean hasCycle(ListNode head) {

        return true;
    }

    // Time: o(n), Space: o(n), faster: 19.88%
    public boolean hasCycleWithHashSet(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p != null; p = p.next) {

            if (set.contains(p)) return true;
            set.add(p);
        }

        return false;
    }

    // Time: o(n), Space:o(1), faster: 100%
    public boolean hasCycleWithTwoPointer(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && slow != null) {

            fast = fast.next;

            if (fast == null) return false;

            fast = fast.next;

            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}