package chapter1.topic1;

import java.util.*;

/**
 * @author donald
 * @date 2020/5/26
 *
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 题意：
 * 给一个可能有重复数字的数组，计算出其全排列
 *
 *
 * 思路：
 * 1. 在 leetcode_46 基础上，增加 hash，去掉重复数组
 *
 * 2. 在1之上优化，计数器版本
 *
 * 3.
 *
 */
public class LeetCode_47 {

    // Time: O(n * n), Space: O(n), Faster: 16.33%
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (null == nums || nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> result = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);

        return new ArrayList<>(result);
    }

    private void permuteRec(List<Integer> nums, int start, Set<List<Integer>> result) {

        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = start; i < nums.size(); ++i) {
            Collections.swap(nums, i , start);
            permuteRec(nums, start + 1, result);
            Collections.swap(nums, i, start);
        }
    }

    // Time: O(n*n!), Space: O(n), Faster: 53.99%
    public List<List<Integer>> permuteUniqueUsingCounter(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            int cnt = counter.getOrDefault(num, 0);
            counter.put(num, cnt+1);
        }

        List<Integer> list = new ArrayList<>();
        permuteRec(list, nums.length, result, counter);
        return result;
    }

    ////////// Counter Version //////////
    private void permuteRec(List<Integer> list, int n, List<List<Integer>> result,
                            Map<Integer, Integer> counter) {
        if (n <= 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
                int cnt = e.getValue();
                if (cnt <= 0) continue;
                list.add(e.getKey());
                e.setValue(cnt-1);
                permuteRec(list, n-1, result, counter);
                e.setValue(cnt);
                list.remove(list.size()-1);
            }
        }
    }

    ////////// NextPermutation Version //////////
    // Time: O(n*n!), Space: O(1), Faster: 99.12%
    public List<List<Integer>> permuteUniqueUsingNextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(toList(nums));
        while (nextPermutation(nums))
            result.add(toList(nums));
        return result;
    }

    // Time: O(n), Space: O(1)
    private boolean nextPermutation(int[] nums) {
        int n = nums.length;
        int p = n - 2;
        while (p >= 0 && nums[p] >= nums[p+1]) --p;

        if (p >= 0) {
            int i = n - 1;
            while (i > p && nums[i] <= nums[p]) --i;
            swap(nums, i, p);
        }
        for (int i = p+1, j = n-1; i < j; ++i, --j)
            swap(nums, i, j);
        return p != -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num: nums) list.add(num);
        return list;
    }

}
