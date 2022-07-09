package chapter1.topic1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. Permutations
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 题意： 给一个数组（数组的数均唯一），求所有组合
 *
 * 思路：
 * 1. 递归计算: 每个字母交换
 * - 根据首字母全排序
 */
public class LeetCode_46 {

    public static void main(String[] args) {

        int [] arr = new int[] {1, 2, 3};

        System.out.println(new LeetCode_46().permute(arr).toString());

    }

    // Time: O(n*n!), Space: O(n) faster: 80.69%
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);
        return result;
    }

    private void permuteRec(List<Integer> list, int start, List<List<Integer>> result) {

        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); ++i) {
            Collections.swap(list, i , start);
            permuteRec(list, start + 1, result);
            Collections.swap(list, start, i);
        }
    }
}
