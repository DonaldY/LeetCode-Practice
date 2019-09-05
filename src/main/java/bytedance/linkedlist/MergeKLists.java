package bytedance.linkedlist;

import java.util.List;

/**
 * 链表与树 - 合并K个排序链表
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 题意： 合并多个列表
 *
 * 思路：
 * 1. 每次合并都创建新节点
 * 2. 复用节点
 */
public class MergeKLists {

    // Time: o()
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        ListNode result = null;

        for (int i = 0; i < lists.length; ++i) {

            result = mergeTwoLists(result, lists[i]);
        }

        return result.next;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0), currNode = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }

        if (l1 != null) currNode.next = l1;
        if (l2 != null) currNode.next = l2;
        return node.next;
    }
}
