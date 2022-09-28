package interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author donald
 * @date 2022/09/28
 *
 * 面试题 17.09. 第 k 个数
 *
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 *
 * 题意： 求第几个质因数
 *
 * 思路：
 * 1. 暴力法： 一个个算
 * 2. 最小堆： 枚举所有的3x、5x、7x，然后按照大小依次进行排列取第k个即可。
 */
public class Interview17_09 {
    // 1. 暴力法
    // Time： O(n*根号3n), Space: O(1), Faster: 超时
    public int getKthMagicNumber(int k) {
        if (k <= 0) return -1;
        int cnt = 0, ans = 0, num = 1;
        while (cnt != k) {
            if (isMagicNumber(num)) {
                ++cnt;
                ans = num;
            }
            ++num;
        }
        return ans;
    }

    private boolean isMagicNumber(int num) {
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 7 == 0) {
            num /= 7;
        }
        return num == 1;
    }

    // 方法二： 最小堆
    // Time: O(n*logn), Space: O(k), Faster: 29.09%
    public int getKthMagicNumberHeap(int k) {
        if (k <= 0) return -1;
        Set<Long> set = new HashSet<>(); // 存放访问过的数
        Queue<Long> queue = new PriorityQueue<>(); // 存放从小到大的数
        // 放第一个数: 1
        set.add(1L);
        queue.add(1L);
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            ans = queue.poll();
            addNumToQueue(ans * 3, set, queue);
            addNumToQueue(ans * 5, set, queue);
            addNumToQueue(ans * 7, set, queue);
        }
        return (int)ans;
    }

    private void addNumToQueue(long num, Set<Long> set, Queue<Long> queue) {
        if (set.contains(num)) return;
        set.add(num);
        queue.add(num);
    }
}
