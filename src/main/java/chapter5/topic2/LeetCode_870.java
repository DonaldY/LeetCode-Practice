package chapter5.topic2;

import java.util.*;

/**
 * @author donald
 * @date 2022/10/08
 *
 * 870. 优势洗牌
 *
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 * 示例 1：
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 *
 * 示例 2：
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 * 思路：
 * 1. 暴力法： 2 层for
 * 2. 哈希表 + TreeSet
 * 3. 双指针 + 排序
 */
public class LeetCode_870 {

    // Time: O(n^2), Space: O(n), Faster: 超时
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) list.add(num);
        int idx = 0;
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; ++i) {
            int max = Integer.MAX_VALUE, index = 0;
            for (int j = 0; j < list.size(); ++j) {
                if (list.get(j) > nums2[i]) {
                    if (max > list.get(j)) {
                        max = list.get(j);
                        index = j;
                    }
                }
            }
            result[idx++] = list.get(index);
            list.remove(index);
        }
        return result;
    }

    // 方法二： TreeSet + 哈希表
    // Time: O(nlogn), Space: O(n), Faster: 5.05%
    public int[] advantageCountHash(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();     // 用来取大值
        Map<Integer, Integer> map = new HashMap<>(); // 用来计数，key 数值， value 出现次数
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 1) tset.add(x);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1); // 找比这个数高的数
            if (cur == null) cur = tset.ceiling(-1);  // 没找到，拿第一个数
            ans[i] = cur;
            map.put(cur, map.get(cur) - 1);          // 更新计数
            if (map.get(cur) == 0) tset.remove(cur); // 这个数已经消失了
        }
        return ans;
    }

    // 方法三： 双指针 + 哈希表
    // Time: O(nlogn), Space: O(n), Faster: 98.06%
    public int[] advantageCountHash3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, List<Integer>> map = new HashMap<>(); // 哈希表记录：nums2 ， key： 值， value 下标
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
            list.add(i);
            map.put(nums2[i], list);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[n];
        // l1: 将 nums1 分配到 nums2 位置
        // l2, r2: 代表还需要计算的值
        for (int l1 = 0, l2 = 0, r2 = n - 1; l1 < n; l1++) {
            int t = nums1[l1] > nums2[l2] ? l2 : r2;
            List<Integer> list = map.get(nums2[t]);
            int idx = list.remove(list.size() - 1);
            ans[idx] = nums1[l1];
            if (t == l2) l2++;
            else r2--;
        }
        return ans;
    }

}
