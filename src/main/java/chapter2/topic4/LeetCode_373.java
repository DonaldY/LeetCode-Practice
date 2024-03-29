package chapter2.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2022/01/15
 *
 * 373. 查找和最小的 K 对数字
 *
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 *
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * 题意：
 *
 *
 * 思路： 堆：优先队列
 * 1. 暴力法： 每个都计算放入堆中
 * 2. 剪枝： 取前 K 个
 *
 */
public class LeetCode_373 {

    // Time: O(klogk), Space: O(k), Faster: 69.91%
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 1. 最小堆，容量为 k，
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,
                (o1, o2)-> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        // 2. 配对 nums1 和 nums2
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        // 3. 加入 nums2
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            ans.add(Arrays.asList(nums1[idxPair[0]], nums2[idxPair[1]]));
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

    // 方法一： 暴力法
    // Time: O(n1*n2*log(k)), Space: O(k), Faster: 超时
    public List<List<Integer>> kSmallestPairsMaxHeap(int[] nums1,
                                                     int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0 || k <= 0) {
            return Collections.emptyList();
        }
        int n1 = nums1.length, n2 = nums2.length;
        // 1. 创建最大堆
        Queue<Elem> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 2. 暴力遍历 2 数组
        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                int sum = nums1[i] + nums2[j];
                if (maxHeap.size() < k) {
                    maxHeap.add(new Elem(i, j, sum));
                } else if (sum < maxHeap.peek().sum) {
                    maxHeap.poll();
                    maxHeap.add(new Elem(i, j, sum));
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(k);
        // 3. 取结果
        while (!maxHeap.isEmpty()) {
            Elem e = maxHeap.poll();
            result.add(0, Arrays.asList(nums1[e.idx1], nums2[e.idx2]));
        }
        return result;
    }

    // 方法二： 剪枝： 取前 K 个
    // Time: O(k*log(k)), Space: O(k), Faster: 97.50%
    public List<List<Integer>> kSmallestPairsMinHeap(int[] nums1,
                                                     int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0 || k <= 0) {
            return Collections.emptyList();
        }
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        Queue<Elem> minHeap = new PriorityQueue<>(); // 最小堆
        // 1. 取 nums1 前k个，均匹配 nums2 第一个元素
        for (int i = 0; i < n1 && i < k; ++i) {
            minHeap.add(new Elem(i, 0, nums1[i] + nums2[0]));
        }
        // 2. 取最小堆前 K 个, [0, 0] 两数组的第一个元素均最小
        for (int i = 0; i < k && !minHeap.isEmpty(); ++i) {
            Elem e = minHeap.poll();
            result.add(Arrays.asList(nums1[e.idx1], nums2[e.idx2]));
            ++e.idx2;
            // 遍历时候，比较加入
            if (e.idx2 < n2) {
                e.sum = nums1[e.idx1] + nums2[e.idx2];
                minHeap.add(e);
            }
        }
        return result;
    }

    class Elem implements Comparable<Elem> {
        int idx1, idx2, sum;

        Elem(int idx1, int idx2, int sum) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.sum = sum;
        }

        @Override
        public int compareTo(Elem o) {
            return this.sum - o.sum;
        }
    }


}
