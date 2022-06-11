package chapter1.topic2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/07/14
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

    private List<String> buildList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row: board)
            list.add(new String(row));
        return list;
    }

    private void solve(int row, int n, List<List<String>> result,
                       char[][] board, boolean[][] visited) {
        if (row == n) {
            result.add(buildList(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (!visited[0][col] && !visited[1][row-col+n] && !visited[2][row+col]) {
                board[row][col] = 'Q';
                visited[0][col] = visited[1][row-col+n] = visited[2][row+col] = true;
                solve(row+1, n, result, board, visited);
                visited[0][col] = visited[1][row-col+n] = visited[2][row+col] = false;
                board[row][col] = '.';
            }
        }
    }
}
