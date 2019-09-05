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
