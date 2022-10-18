package chapter4.topic3;

import java.util.*;

/**
 * 703. Kth Largest Element in a Stream
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * 题意：找到第K大的数
 *
 * 思路：
 * 1. 两个队列，先进先出
 * 2. 添加后，再排序
 * 3. 添加时候，就比对，记录第k大的数
 * 4. 用最小堆，维护k的池子
 */
public class LeetCode_703 {

    public class KthLargestElementInStream {

        // 优先队列，默认就是一个最小堆实现
        private Queue<Integer> minHeap = new PriorityQueue<>();
        private int k;

        // Time: o(n * log(k)), Space: o(k), Faster: 96.69%
        public KthLargestElementInStream(int k, int [] nums) {
            this.k = k; // 定义长度为 k 的队列
            for (int num : nums) add(num);
        }

        // Time: o(log(k))
        public int add (int val) {
            if (minHeap.size() < k) { // 队列不满
                minHeap.add(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
            return minHeap.peek(); // 直接出最小
        }
    }

}
