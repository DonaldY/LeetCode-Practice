package bytedance.datastruct;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 数据结构 - 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 题意: 设计最小栈
 *
 * 思路:
 * 1. 用优先队列保证最小值, stack保证栈
 * 2. 或者两个栈, 一个保存原始数, 一个保存最小数(只有比当前的数小的数, 才能加入)
 */
public class MinStack {

    private Queue<Integer> queue = new PriorityQueue<>();

    private Stack<Integer> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {

        queue.add(x);
        stack.push(x);
    }

    public void pop() {

        if (stack.isEmpty() || queue.isEmpty()) return;

        Integer num = stack.pop();

        queue.remove(num);
    }

    public int top() {

        if (stack.isEmpty()) return 0;

        return stack.peek();
    }

    public int getMin() {

        if (stack.isEmpty() || queue.isEmpty()) return 0;

        return queue.peek();
    }
}


// Time: o(n) Space: o(n) faster: 73.84%
class MinStack2 {

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