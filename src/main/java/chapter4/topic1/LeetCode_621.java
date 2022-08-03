package chapter4.topic1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/08/03
 *
 * 这个题目说的是，给你一个字符数组和一个**非负整数** n。字符数组表示等待 CPU 处理的任务，每个任务用 A 到 Z 中的一个字符表示，并且每个任务都可以在一个时间单位内完成；n 表示冷却时间，即相同任务之间需要间隔至少 n 个时间单位才能再次执行，冷却时间内的每个时间单位，可以选择执行不同的任务或是让 CPU 处于闲置状态。
 *
 * 现在你要重新组织任务的执行顺序，并计算出最少需要多少个时间单位才能完成所有任务。
 *
 * # 比如说，给你的任务数组是：
 * A, A, A, B, B, B, D
 *
 * # 给你的冷却时间是：
 * n = 2
 *
 * # 完成所有任务最少需要 8 个时间单位，一种执行序列是：
 * A, B, D, A, B, _, A, B
 *
 * 序列中的 '_' 表示 CPU 处于闲置状态。
 *
 * 因此，对于这个例子，你要返回 8。
 *
 * 思路：
 * 1. 方法一：最大堆
 * 2. 方法二：数学方法
 */
public class LeetCode_621 {

    // 方法一：最大堆
    // Time: O(m), Space: O(1), Faster: 35.62%
    public int leastIntervalMaxHeap(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        // 1. 统计每个任务数量
        int[] freqs = new int[26];
        for (char t : tasks) ++freqs[t - 'A'];

        // 2. 构建最大堆
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqs) {
            if (freq != 0) q.add(freq);
        }

        // 3. 遍历最大堆
        int result = 0, idle = 0; // idle：最后一个分组有几个空闲
        while (!q.isEmpty()) {
            result += (n + 1);
            idle = n + 1 - q.size();
            int size = Math.min(n + 1, q.size());
            for (int i = 0; i < size; ++i) {
                freqs[i] = q.poll() - 1;
            }
            for (int i = 0; i < size; ++i) {
                if (freqs[i] != 0) q.add(freqs[i]);
            }
        }
        return result - idle;
    }

    // 方法二：数学方法
    // Time: O(m), Space: O(1), Faster: 100.00%
    public int leastIntervalMath(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        // 1. 统计每个任务数量
        int[] freqs = new int[26];
        for (char t : tasks) ++freqs[t - 'A'];

        // 2. 求 maxFreq 和 cnt
        // maxFreq: 任务出现次数最多
        // cnt: 有多少个 maxFreq
        int maxFreq = 0, cnt = 0;
        for (int freq : freqs) {
            if (freq > maxFreq) {
                maxFreq = freq;
                cnt = 1;
            } else if (freq == maxFreq) {
                ++cnt;
            }
        }

        // 3. 计算
        int result = (n + 1) * (maxFreq - 1) + cnt;
        // 取最大值
        return Math.max(result, tasks.length);
    }
}
