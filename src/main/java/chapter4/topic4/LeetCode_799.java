package chapter4.topic4;

/**
 * @author donald
 * @date 2022/11/20
 */
public class LeetCode_799 {

    // 方法一： 模拟
    // Time: O(query_row ^ 2), Space: O(query_row), Faster: 100%
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured}; // 初始第一层
        // 模拟遍历每一层
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1]; // 存储每一层
            // 每层
            for (int j = 0; j < i; j++) {
                double volume = row[j];  // 上一层的的数
                if (volume > 1) {
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
        }
        return Math.min(1, row[query_glass]);
    }
}
