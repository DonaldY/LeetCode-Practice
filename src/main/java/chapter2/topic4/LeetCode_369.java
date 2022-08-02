package chapter2.topic4;

/**
 * @author donald
 * @date 2021/03/17
 *
 * LeetCode
 *
 *
 * 题意： 给你一个不为空的单链表，它表示一个非负整数。
 *       链表中的每个节点值都位于 0~9 之间，代表整个非负整数中的一位。你要将这个非负整数加 1，然后返回结果链表。
 *
 * 比如说，给你的链表是：
 *
 * 1 -> 2 -> 4
 *
 * 它表示整数 124，加 1 等于 125，于是你要返回链表：
 *
 * 1 -> 2 -> 5
 *
 *
 * 思路：
 * 1. 转换为数组，操作完之后再转换为链表
 * 2. 两指针
 *    t 指针指向当前 != 9 的位置
 *    p 一直向后遍历
 *
 * 0 -> 1 -> 2 -> 9 -> 9
 *      p    p    p    p   p
 * t    t    t
 * 那么 t = t + 1, t 之后的均为 0
 *
 * 0 -> 9 -> 9 -> 9
 *      p    p    p  p
 * t
 *
 * 所有需要一个头节点保存
 */
public class LeetCode_369 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Time: O(n), Space: O(1)
    public ListNode plusOne(ListNode head) {

        ListNode maybe = new ListNode(0), notNine = maybe;
        maybe.next = head;
        // 1. 找到最后一个不是 9 的节点：notNine
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val != 9)
                notNine = p;
        }
        // 2. notNine 的数值 +1
        notNine.val += 1;
        // 3. notNine 之后的节点的数值均赋值为 0
        for (ListNode p = notNine.next; p != null; p = p.next) {
            p.val = 0;
        }
        // 4. 判断需不需要额外头节点
        if (notNine == maybe) return maybe;
        else return head;
    }
}


