package chapter9.topic3;

/**
 * @author donald
 * @date 2022/02/05
 *
 * 1725. 可以形成最大正方形的矩形数目
 *
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 * 请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
 *
 * 示例 1：
 * 输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * 输出：3
 * 解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
 * 最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
 *
 * 示例 2：
 * 输入：rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * 输出：3
 *
 *
 * 题意：求正方形
 *
 * 思路：找最小边
 */
public class LeetCode_1725 {

    // Time: O(n), Space: O(n), Faster: 100.00%
    public int countGoodRectangles(int[][] rectangles) {

        if (null == rectangles || rectangles.length == 0) return 0;

        int ans = 0;
        int maxLen = 0;

        for (int[] rectangle : rectangles) {

            int tmp = Math.min(rectangle[1], rectangle[0]);
            if (tmp == maxLen) {
                ++ans;
            } else if (tmp > maxLen) {
                maxLen = tmp;
                ans = 1;
            }
        }

        return ans;
    }
}