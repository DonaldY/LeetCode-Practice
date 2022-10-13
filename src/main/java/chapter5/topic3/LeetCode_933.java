package chapter5.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/10/13
 *
 * 思路： 比较队首元素和准备入队元素，是否相差 3000，超过则出队
 */
public class LeetCode_933 {
}

// Faster: 53.30%
class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
}