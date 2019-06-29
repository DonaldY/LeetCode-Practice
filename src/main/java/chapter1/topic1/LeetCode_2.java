package chapter1.topic1;

import java.util.List;

/**
 * LeetCode 2
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * 题意：
 * 给出两个链表，对应位相加，并得出新链表
 * (有进位一说）
 *
 * Tips: 题意没有说两个链表相等长度
 *
 * 思路：
 * 1. 先找出最长链表 l1 ，以此为主线
 * 2. 取出 l1 l2 的数进行相加， 有进位则记录下来
 * 3. 若 `l1.next == null && carry != 0`, 说明有进位，但没有下一个数，这时候需要创建新节点
 */

// 没有头指针
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode_2 {

    public static void main(String[] args) {

        LeetCode_2 addTwoNumbers = new LeetCode_2();

        ListNode l1 = initL1();
        ListNode l2 = initL2();

        ListNode headNode = addTwoNumbers.addTwoNumbers(l1, l2);

        while (null != headNode) {

            System.out.println(headNode.val);

            headNode = headNode.next;
        }
    }

    private static ListNode initL2() {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        return l1;
    }

    private static ListNode initL1() {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;

        return l1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Length = getNodeListLength(l1);
        int l2Length = getNodeListLength(l2);

        if (l1Length < l2Length) {

            ListNode tempNode = l1;
            l1 = l2;
            l2 = tempNode;
        }

        ListNode headNode = l1;

        int num = 0;
        int carry = 0;

        while (null != l1) {

            num = 0;

            if (null != l2) {

                num = l2.val;
                l2 = l2.next;
            }

            int temp = l1.val;

            l1.val = (l1.val + num + carry) % 10;

            carry = (temp + num + carry) / 10;

            if (null == l1.next && carry != 0) {

                l1.next = new ListNode(carry);
                break;
            }

            l1 = l1.next;
        }

        return headNode;
    }

    private int getNodeListLength(ListNode l) {

        int length = 0;

        while (null != l) {

            ++ length;

            l = l.next;
        }

        return length;
    }

    // Time: o(max(m, n)), Space: o(max(m,n)) ,Faster: 100%
    public ListNode addTwoLinkedListNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
