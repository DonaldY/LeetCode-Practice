package bytedance.linkedlist;

/**
 * 链表与树
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 题意： 链表两个相加
 *
 * 思路：
 * 直接迭代相加
 *
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(8);
        l2.next = null;
        l3.next = null;
        l2.next = l3;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2));
    }

    // Time: o(n), Space: o(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0), p = node;

        int pow = 0;

        while (l1 != null || l2 != null || pow != 0) {

            int sum = pow;

            if (l1 != null) {

                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {

                sum += l2.val;
                l2 = l2.next;
            }

            ListNode temp = new ListNode(sum % 10);
            pow = sum / 10;
            p.next = temp;
            p = temp;
        }

        return node.next;
    }
}
