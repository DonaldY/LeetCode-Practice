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
 * 3. 动态规划： 3个指针记录
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/solution/di-kge-shu-by-capital-worker-c4pz/
 */
public class Interview17_09 {
    public static void main(String[] args) {

        String st = "123";
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = str2.intern(); //get an interned string obj

        System.out.println(str1 == str2); //prints false
        System.out.println(str1 == str3); //prints true
    }

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
    
    // 方法三： 动态规划
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int getKthMagicNumberDP(int k) {
        if (k <= 0) return -1;
        int[] nums = new int[k + 1];
        int num3 = 0, num5 = 0,num7 = 0;
        nums[0] = 1;
        for(int i = 1 ; i < k; i++){
            nums[i] = Math.min(Math.min(nums[num3] * 3, nums[num5] * 5), nums[num7] * 7);
            if(nums[i] == nums[num3] * 3) num3++;
            if(nums[i] == nums[num5] * 5) num5++;
            if(nums[i] == nums[num7] * 7) num7++;
        }
        return nums[k-1];
    }
}
