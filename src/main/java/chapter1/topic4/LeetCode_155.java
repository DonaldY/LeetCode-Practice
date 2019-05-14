package chapter1.topic4;

import java.util.Stack;

/**
 * 155. Min Stack
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * 题意： 最小栈，能找到最小值
 *
 * 思路：
 * 1. 存两个栈，一个用于原始数据，一个保存最小
 *    - minStack 只保存最小的
 */
public class LeetCode_155 {

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

}

// Time: o(n) Space: o(n) faster: 73.84%
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= getMin()) min.push(x);
    }

    public void pop() {
        if (stack.peek() == getMin()) min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
