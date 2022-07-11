package chapter1.topic2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/07/14
 *
 * 52. N皇后 II
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * 思路：参考 LeetCode 51
 */
public class LeetCode_52 {

    // Time: O(n!), Space: O(n^2), Faster: 61.24%
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] visited = new boolean[3][2*n];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }

        solve(0, n, result, board, visited);
        return result.size();
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
