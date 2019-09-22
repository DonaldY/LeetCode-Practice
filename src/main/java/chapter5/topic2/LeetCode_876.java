package chapter5.topic2;


/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 题意：
 * 找到链表中的中间节点
 *
 * 思路：
 * 1. 求总数，再找中间节点
 * 2. 快指针 和 慢指针
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode_876 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public ListNode middleNode(ListNode head) {

        if (head == null) return head;

        ListNode p = head;

        int size = 0;

        while (p != null) {

            ++size;
            p = p.next;
        }

        int mid = size / 2 + 1;

        p = head;

        while (--mid > 0) {

            p = p.next;
        }

        return p;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public ListNode getMiddleNodeOnePass(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
