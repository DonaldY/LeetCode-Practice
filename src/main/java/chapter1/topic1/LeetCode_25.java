package chapter1.topic1;

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
 *              -------------
 *       1  --> | 2  -->  3 | -->  4  -->  5
 *              -------------
 *       ^        ^       ^
 *       |        |       |
 *      pre      curr    next
 *
 * 链表结点按照 k 个一组分组，所以可以使用一个指针 head 依次指向每组的头结点。
 * 这个指针每次向前移动 k 步，直至链表结尾。
 * 对于每个分组，先判断它的长度是否大于等于 k。若是，就翻转这部分链表，否则不需要翻转。
 *
 * 在翻转子链表的时候，不仅需要子链表头结点 head，还需要有 head 的上一个结点 pre，以便翻转完后把子链表再接回 pre。
 *
 */
public class LeetCode_25 {

    // Time: 0(n), Space: 0(1), Faster: 100.00%
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummp = new ListNode(0);

        ListNode pre = dummp, curr = head, next = head;

        int cnt = k;

        while (next != null) {

            if (cnt == 1) {

                ListNode start = curr, end = next;
                next = next.next;
                end.next = null;
                curr = next;

                reverse(start);

                pre.next = end;
                pre = start;
                start.next = next;

                cnt = k;
                continue;
            }
            --cnt;
            next = next.next;
        }

        return dummp.next;
    }

    private void reverse(ListNode curr) {

        ListNode pre = null;

        while (curr != null) {

            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
    }
}
