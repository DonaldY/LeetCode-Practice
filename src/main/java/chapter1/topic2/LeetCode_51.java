package chapter1.topic2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/07/14
 *
 * 51. N 皇后
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 思路：回溯思想
 */
public class LeetCode_51 {

    // Time: O(n!), Space: O(n^2), Faster: 99.80%
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] visited = new boolean[3][2*n];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }

        solve(0, n, result, board, visited);
        return result;
    }

    private void solve(int row, int n, List<List<String>> result,
                       char[][] board, boolean[][] visited) {
        if (row == n) {
            result.add(buildList(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            // 列、主对角线、副对角线
            if (!visited[0][col] && !visited[1][row-col+n] && !visited[2][row+col]) {
                board[row][col] = 'Q';
                visited[0][col] = visited[1][row-col+n] = visited[2][row+col] = true;
                solve(row+1, n, result, board, visited);
                visited[0][col] = visited[1][row-col+n] = visited[2][row+col] = false;
                board[row][col] = '.';
            }
        }
    }

    private List<String> buildList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row: board) {
            list.add(new String(row));
        }
        return list;
    }
}
