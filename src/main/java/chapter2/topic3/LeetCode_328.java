package chapter2.topic3;

/**
 * @author donald
 * @date 2021/03/16
 *
 * LeetCode 328. Odd Even Linked List
 *
 * Given the head of a singly linked list,
 * group all the nodes with odd indices together followed by the nodes with even indices,
 * and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * ```
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 *
 * Example 2:
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * ```
 *
 * 题意： 给你一个单链表，你要重新排列这个链表，把奇数节点全都放到链表前面，偶数节点全都放到链表后面，并且奇数节点内和偶数节点内的节点相对顺序保持不变。
 *
 * 注意，这里说的奇数和偶数，指的是节点的位置，而不是节点值。
 * 并且把头节点看作第一个节点，也就是说头节点是奇数节点。
 * 这个题目的时间复杂度要求是 O(n)，空间复杂度要求是 O(1)。
 *
 * 思路：
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode_328 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
