package bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 数组与排列 - 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 题意: 合并所有重复的区间
 *
 * 思路:
 * 1. 先排序(按开始下标开始排序)
 *
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {

        List<List<Integer>> result = new ArrayList<>(intervals.length);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[0] > t2[0]) return 1;
                else if (t1[0] < t2[0]) return -1;
                return 0;
            }
        });

        for (int [] arr : intervals) {

            int n = result.size();

            if (result.isEmpty() || result.get(n - 1).get(1) < arr[0]) {
                result.add(Arrays.asList(arr[0], arr[1]));
            } else {
                result.get(n - 1).set(1, Math.max(result.get(n - 1).get(1), arr[1]));
                result.get(n - 1).set(0, Math.min(result.get(n - 1).get(0), arr[0]));
            }
        }

        int [][] resultArr = new int[result.size()][2];

        int i = 0;
        for (List<Integer> list : result) {

            resultArr[i][0] = list.get(0);
            resultArr[i][1] = list.get(1);

            ++i;
        }

        return resultArr;
    }
}
