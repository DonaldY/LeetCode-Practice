package chapter1.topic2;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * 题意： 给一个有序的链表，删除重复的数
 *
 *
 * 思路：
 * 1. 使用当前指针和上个指针，若当前与上个相同，则删除当前
 * 2. 使用当前指针和下个指针，若当前与下个相同，则删除下个
 * 3. 用 `HashMap` 保存，然后比对
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode_83 {

    // Time: o(n), Space: o(1), Faster: 34.28%
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode preNode = head, currNode = head.next;

        while (currNode != null) {

            if (preNode.val == currNode.val) {

                preNode.next = currNode.next;
                currNode.next = null;
                currNode = preNode.next;

                continue;
            }

            preNode = currNode;
            currNode = currNode.next;
        }

        return head;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public ListNode removeDuplicatesInSortedList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, next = head.next;
        while (next != null) {
            if (cur.val == next.val)
                cur.next = next.next;
            else
                cur = cur.next;
            next = next.next;
        }
        return head;
    }

}
