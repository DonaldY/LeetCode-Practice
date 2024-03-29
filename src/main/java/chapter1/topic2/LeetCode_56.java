package chapter1.topic2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * 题意：合并所有重叠区间（题目无排序）
 *
 * 思路：
 * 1. 比较大小, 小于最小，大于最大，
 *
 * 2. 先排序，再比较
 */
public class LeetCode_56 {

    public static void main(String[] args) {

        LeetCode_56 leetCode_56 = new LeetCode_56();

        int [][] arr = new int[][] {

                /*new int[] {1, 3},
                new int[] {2, 6},
                new int[] {8, 10},
                new int[] {15, 18}*/
                new int[] {1, 4},
                new int[] {0, 0}
        };

        System.out.println(Arrays.toString(leetCode_56.merge(arr)));
    }

    // Time: o(nlog(n)), Space: o(n), Faster: 57.26%
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


    public class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        // intervals.sort(Comparator.comparingInt(a -> a.start));
        //intervals.sort((a, b) -> a.start - b.start);

        for (Interval in : intervals) {
            int n = result.size();
            if (result.isEmpty() || result.get(n - 1).end < in.start) {
                result.add(in);
            } else {
                result.get(n - 1).end = Math.max(result.get(n - 1).end, in.end);
            }
        }

        return result;
    }

    // Time: o(nlog(n)), Space: o(n), Faster: 91.03%
    public int[][] mergeArr(int[][] intervals) {
        // 1. 按照开始时间升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 升序排序

        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        // 2. 合并
        int[] pre = intervals[0].clone(); // 前数组，先 clone 一份
        for (int i = 1; i < n; ++i) {
            int preStart = pre[0], preEnd = pre[1];  // 上一个区间
            int curStart = intervals[i][0], curEnd = intervals[i][1]; // 当前区间
            if (curStart >= preStart && curStart <= preEnd) { // 2.1 区间有交集
                // 合并区间
                pre = new int[] {preStart, Math.max(preEnd, curEnd)};

            } else {  // 没有交集，可以把上一个区间放入结果
                result.add(pre);
                pre = intervals[i];
            }
        }
        result.add(new int[]{pre[0], pre[1]}); // 最后一个也加入

        // 3. 返回结果
        return result.toArray(new int[result.size()][]);
    }

}
