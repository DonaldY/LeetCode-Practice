package chapter1.topic4;

import java.util.List;

/**
 * 160. Intersection of Two Linked Lists
 *
 * A:     1 -> 2
 *               \
 *                6 -> 7 -> null
 *               /
 * B: 3 -> 4 -> 5
 *
 * 你要返回的是 6 这个节点。
 *
 *
 * 题意： 给出两个链表，找出最早相交的节点
 *
 * 思路：
 * 1. 把两个链表节点都记录下来，然后逐个比较
 * 2. 两层循环比较
 * 3. 找到两个链表末尾节点，然后向前找最近交叉点
 * 4. 入栈，然后出栈，相互比较
 * 5.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        return null;
    }

    // Time: o(m + n), Space: o(1)
    public ListNode getIntersectionNodeWithLen(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;

        for (ListNode p = headA; p != null; p = p.next, ++lenA);
        for (ListNode q = headB; q != null; q = q.next, ++lenB);

        ListNode p = headA, q = headB;

        if (lenA > lenB)
            for (int i = 0; i < lenA - lenB; ++i) p = p.next;
        else
            for (int i = 0; i < lenB - lenA; ++i) q = q.next;

        while (p != q) {

            p = p.next;
            q = q.next;
        }

        return p;
    }

    // Time: o(m + n), Space: o(1), faster: 97.23%
    // 距离差问题，循环查找
    public ListNode getIntersectionNodeWithoutLen(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;

        // 这个前提必须有相交点
        while (p != q) {

            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }
}
