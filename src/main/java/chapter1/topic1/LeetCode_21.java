package chapter1.topic1;

/**
 * 21. Merge Two Sorted Lists
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * 题意： 合并两个链表, 并排序
 *
 *
 */
public class LeetCode_21 {

    public static void main(String[] args) {

        ListNode node1 = initNode1();
        ListNode node2 = initNode2();

        LeetCode_21 leetCode = new LeetCode_21();
        leetCode.mergeTwoLists(node1, node2);
    }

    private static ListNode initNode1() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    private static ListNode initNode2() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    // Time: o(m + n) Space: o(1) faster: 100%
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0), p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }
}
