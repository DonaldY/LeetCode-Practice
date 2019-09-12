package bytedance.linkedlist;

/**
 * 链表与树 - 相交链表
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 题意: 找到相交的节点
 *
 * 思路:
 * 若相交, 则最后节点一定相同
 *
 * 其实只要保证两个指针走的距离一样就行, 如同下面两个方法
 *
 * 1. 长度相同, 先找到两个链表的长度, 再在同长度下查找
 * 2. 交互查找, 两指针都走了同样的距离
 */
public class IntersectionNode {

    // Time: o(n), Space: o(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;

        for (ListNode tmp = headA; tmp != null; tmp = tmp.next) ++lenA;
        for (ListNode tmp = headB; tmp != null; tmp = tmp.next) ++lenB;

        ListNode p = headA;
        ListNode q = headB;

        if (lenA > lenB) for (; lenA != lenB; --lenA) p = p.next;
        else for (; lenB != lenA; --lenB) q = q.next;

        while (p != q) {

            p = p.next;
            q = q.next;
        }

        return p;
    }

    // Time: o(n + m), Space: o(1)
    public ListNode getIntersectionNodeWithoutLen(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode p = headA, q = headB;

        while (p != q) {

            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }
}
