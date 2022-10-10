package chapter3.topic1;


import java.util.Stack;

/**
 * @author donald
 * @date 2022/10/10
 */
public class LeetCode_445 {

    // Time: O(n), Space: O(1), Faster: 23.01%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (ListNode p = l1; p != null; p = p.next) stack1.push(p.val);
        for (ListNode p = l2; p != null; p = p.next) stack2.push(p.val);
        int next = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int num = stack1.pop() + stack2.pop() + next;
            next = num / 10;
            ListNode node = new ListNode(num % 10);
            node.next = cur;
            cur = node;
        }
        while (!stack1.isEmpty()) {
            int num = stack1.pop() + next;
            next = num / 10;
            ListNode node = new ListNode(num % 10);
            node.next = cur;
            cur = node;
        }
        while (!stack2.isEmpty()) {
            int num = stack2.pop() + next;
            next = num / 10;
            ListNode node = new ListNode(num % 10);
            node.next = cur;
            cur = node;
        }
        if (next != 0) {
            ListNode node = new ListNode(next);
            node.next = cur;
            cur = node;
        }
        return cur;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
