package chapter2.topic3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/10/13
 */
public class LeetCode_346 {


}

// Faster: 63.94%
class MovingAverage {

    private int sum;
    private int capacity;
    private Queue<Integer> queue;

    public MovingAverage(int size) {
        this.sum = 0;
        this.capacity = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (!queue.isEmpty() && queue.size() == capacity) {
            int num = queue.poll();
            sum -= num;
        }
        queue.add(val);
        sum += val;
        return sum * 1.0 / queue.size();
    }
}