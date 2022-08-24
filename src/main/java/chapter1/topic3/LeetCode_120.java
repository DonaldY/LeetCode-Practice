package chapter1.topic3;

import java.util.List;

/**
 * @author donald
 * @date 2022/08/24
 *
 * 三角形中的最小路径和
 *
 * 这个题目说的是，给你一个数字三角形，你要找到从上到下路径和最小的一条路径，然后返回这个最小的路径和。
 *
 * 注意，每一次你只能移动到下一行相邻的两个数字上。
 *
 * 比如说，给你的数字三角形 a 是：
 *
 * [
 *     [1],
 *    [2,3],
 *   [4,5,1],
 *  [6,1,1,8]
 * ]
 *
 * 在这个三角形中，路径和最小的路径是 [1,3,1,1]。它的和等于 6。因此，你要返回的最小路径和就是 6。
 *
 *
 * 思路：
 * 1. 暴力法 dfs
 */
public class LeetCode_120 {

    int min = Integer.MIN_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) return 0;
        dfs(0, 0, 0, triangle);
        return min;
    }

    private void dfs(int sum, int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size()) {
            min = Math.min(min, sum);
            return;
        }
        if (j < 0 || j >= triangle.get(i).size()) {
            return;
        }
        sum += triangle.get(i).get(j);
        dfs(sum, i + 1, j + 1, triangle);
        dfs(sum, i + 1, j, triangle);
        dfs(sum, i + 1, j - 1, triangle);
    }


}
