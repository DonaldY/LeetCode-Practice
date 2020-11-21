package bytedance.linkedlist;

/**
 * @author donald
 * @date 2020/11/21
 *
 * Leetcode 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 思路：
 * 1. 直接反转
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ReverseNodesInKGroup r = new ReverseNodesInKGroup();

        r.reverseKGroup(node1, 3);
    }

    // Time: 0(n), Space: 0(1), Faster:
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        ListNode p = cur, q;

        int cnt = k;

        while (cur != null) {

            if (cnt == k) {

                p = cur;
                --cnt;

            } else if (cnt == 1) {

                q = cur;
                reverse(p, q);
                cnt = k;

            } else {

                --cnt;
            }

            cur = cur.next;
        }

        return head;
    }

    private static void reverse(ListNode p, ListNode q) {

        ListNode cur = p;
        int t = q.val;

        while (cur != q) {

            int tmp = cur.val;
            cur.val = t;

            t = tmp;
            cur = cur.next;
        }
        cur.val = t;
    }
}
