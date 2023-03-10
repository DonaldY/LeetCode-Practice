package chapter12.topic3;

/**
 * @author donald
 * @date 2023/01/31
 */
public class LeetCode_2319 {

    // Time: O(n^2), Space: O(1), Faster: 99.60%
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || (i + j) == (n - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
