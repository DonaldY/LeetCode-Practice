package chapter2.topic1;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * 题意：用栈来实现队列
 *
 * 思路：
 * 1. 用栈来模拟
 */
public class LeetCode_232 {

    // Time: O(n), Space: O(n), Faster: 36.88%
    class MyQueue {

        private Stack<Integer> stack;
        private Stack<Integer> backupStack;

        public MyQueue() {

            this.stack = new Stack<>();
            this.backupStack = new Stack<>();
        }

        public void push(int x) {

            stack.push(x);
        }

        public int pop() {

            while (!stack.isEmpty()) {

                backupStack.push(stack.pop());
            }

            int result = backupStack.pop();

            while (!backupStack.isEmpty()) {

                stack.push(backupStack.pop());
            }

            return result;
        }

        public int peek() {

            while (!stack.isEmpty()) {

                backupStack.push(stack.pop());
            }

            int result = backupStack.peek();

            while (!backupStack.isEmpty()) {

                stack.push(backupStack.pop());
            }

            return result;
        }

        public boolean empty() {

            return stack.isEmpty();
        }
    }

    class MyQueue2 {

        private Stack<Integer> in = new Stack<>(), out = new Stack<>();

        private void transferIfEmpty() {
            if (out.empty())
                while (!in.empty())
                    out.push(in.pop());
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            transferIfEmpty();
            return out.pop();
        }

        public int peek() {
            transferIfEmpty();
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }

}
