package chapter1.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2022/08/23
 *
 * 数字组合
 *
 * 这个题目说的是，给你两个正整数 n 和 k，你要从 1 ~ n 中取 k 个数字，并返回所有可能的数字组合。
 *
 * 比如说，给你的 n 和 k 分别是：
 *
 * n = 4
 * k = 2
 *
 * 你要从 1 ~ 4 中取 2 个数字，一共有 6 种可能的组合：
 *
 * [1, 2]
 * [1, 3]
 * [1, 4]
 * [2, 3]
 * [2, 4]
 * [3, 4]
 *
 *
 * 思路：
 * 1. 回溯: 时间复杂度就是一颗多叉树
 */
public class LeetCode_77 {

    // 方法一： 回溯
    // Time: O(k*C(n, k)), Space: O(1), Faster: 35.26%
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            trackBack(i, n, k, list, result);
        }
        return result;
    }

    private void trackBack(int now, int n, int k, List<Integer> arr, List<List<Integer>> result) {
        if (arr.size() == k) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = now + 1; i <= n; ++i) {
            arr.add(i);
            trackBack(i, n, k, arr, result);
            arr.remove(arr.size() - 1);
        }
    }


    private void combine(int n, int k, int start,
                         List<Integer> elem, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(elem));
        } else {
            for (int i = start; i <= n - k + 1; ++i) {
                elem.add(i);
                combine(n, k - 1, i + 1, elem, result);
                elem.remove(elem.size() - 1);
            }
        }
    }

    // Time: O(k*C(n, k)), Space: O(k)
    public List<List<Integer>> combineRecursive(int n, int k) {
        if (k > n) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        combine(n, k, 1, elem, result);
        return result;
    }

    // Time: O(k*C(n, k)), Space: O(k*C(n, k))
    public List<List<Integer>> combineIterative(int n, int k) {
        if (k > n) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; ++i) result.add(Arrays.asList(i));
        for (int i = 2; i <= k; ++i) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> elem : result) {
                int lastNum = elem.get(elem.size() - 1);
                for (int j = lastNum + 1; j <= n - k + i; ++j) {
                    List<Integer> copy = new ArrayList<>(elem);
                    copy.add(j);
                    tmp.add(copy);
                }
            }
            result = tmp;
        }
        return result;
    }
}
