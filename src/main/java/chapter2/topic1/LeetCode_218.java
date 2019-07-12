package chapter2.topic1;

import java.util.*;

/**
 * 218. The Skyline Problem
 *
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B)
 * in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point,
 * where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * 题意： 给一组数据[坐标x1， 坐标x2， 高度]， 描绘天际线，起始点不包括
 *       描绘出关键点，即可根据关键点描绘出天际线
 *       Tips： 数组有序
 *
 * 思路：
 * 1. 先生成所有节点
 * 2. 再将节点根据x轴进行排序
 * 3. 选择更新
 *
 * 思路2：
 * 关键点搜索算法：
 * 1. 扫描线从左向右移动
 * 2. 遇到矩形左边，加入高度值;遇到矩形右边，移除高度值
 * 3. 最大高度值发生变化时，产生一个新的关键点。
 *    横坐标是当前矩形边的横坐标，纵坐标是当前最大高度值
 */
public class LeetCode_218 {

    // Time: o(n ^ 2), Space: o(n), Faster: 20.81%
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        height.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int preHeight = 0;
        for (int [] h: height) {
            if (h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]); // Time: o(n)

            if (pq.peek() != preHeight) {
                result.add(Arrays.asList(h[0], pq.peek()));
                preHeight = pq.peek();
            }
        }
        return result;
    }

    // TreeMap 的实现是红黑树，也就是一棵自平衡的排序二叉树
    // 使用 TreeMap 做优化, 时间复杂度降到 O(nlogn)
    // Time: O(nlog(n)), Space: O(n)
    public List<int[]> skylineKeyPointsTreeMap(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b: buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        height.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1);
        int prevHeight = 0;
        for (int[] h: height) {
            if (h[1] < 0) {
                // 这里和使用最大堆不同，TreeMap 中每个元素是一对 (key, value)，并按 key 排序
                // 如果直接把高度值（height, 1）加入 TreeMap，会导致多个相同的高度值互相覆盖，从而出错。
                // 因此这里要把相同的高度值的计数也保存下来，在遇到矩形结束时，只有在当前高度值只剩 1 个，才 remove
                Integer cnt = heightMap.get(-h[1]);
                cnt = (cnt == null) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                // 在遇到矩形结束时，只有在当前高度值只剩 1 个，才 remove
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]); // Time: O(log(n))
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            // 由于是从小到大排序,所以最大值在 lastKey
            // Time: O(log(n))
            int currHeight = heightMap.lastKey();
            if (prevHeight != currHeight) {
                result.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return result;
    }
}
