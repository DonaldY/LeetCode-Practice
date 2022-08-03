package chapter4.topic1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/08/03
 */
public class LeetCode_621 {

    // Time: O(m), Space: O(1), Faster: 35.62%
    public int leastIntervalMaxHeap(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        int[] freqs = new int[26];
        for (char t: tasks) ++freqs[t - 'A'];
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq: freqs)
            if (freq != 0)
                q.add(freq);

        int result = 0, idle = 0;
        while (!q.isEmpty()) {
            result += (n + 1);
            idle = n + 1 - q.size();
            int size = Math.min(n+1, q.size());
            for (int i = 0; i < size; ++i)
                freqs[i] = q.poll() - 1;
            for (int i = 0; i < size; ++i)
                if (freqs[i] != 0)
                    q.add(freqs[i]);
        }
        return result - idle;
    }
}
