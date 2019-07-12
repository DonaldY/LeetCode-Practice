package chapter2.topic1;

import java.util.List;

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
 */
public class LeetCode_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        return null;
    }
}
