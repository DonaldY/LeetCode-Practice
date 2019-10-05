package chapter2.topic1;

/**
 * 237. Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5,
 * the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 * 题意： 只给出要删除节点的指针，需要删除这个节点
 *
 * 思路：
 * 当前节点赋值下一个节点的值，删除下一个节点
 */
public class LeetCode_237 {

    // Time: O(1), Space: O(1), Faster:
    public void deleteNode(ListNode node) {

        if (node == null) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
