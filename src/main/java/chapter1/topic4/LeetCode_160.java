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


    }
}
