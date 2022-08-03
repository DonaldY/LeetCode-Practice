package chapter1.topic4;


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
 * 1. 暴力法： 先计算两个链表长度
 *    1. 长度长的先走多出的几步
 *    2. 一起走，比较是否相等
 *
 * 2. 走相同的距离，有相交的节点就会相遇：
 *    p 先走 a 链，走完走 b 链
 *    q 先走 b 链，走完走 a 链
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

    // 方法一：
    // Time: o(m + n), Space: o(1), Faster： 97.89%
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
