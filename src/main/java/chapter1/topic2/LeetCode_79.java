package chapter1.topic2;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * 题意： 给你一个二维字符矩阵和一个单词，
 * 矩阵中的字符可以和它上/下/左/右的字符连接起来形成单词，并且每个位置的字符不能重复使用。
 * 你要判断给你的单词是否存在于字符矩阵中。
 *
 * 思路：
 * 1. 暴力搜索 dfs
 */
public class LeetCode_79 {

    // Time: O(m * n * 3 ^ k), Space: O(n * m), Faster: 62.80%
    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0) return true;

        if (board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0) return false;

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {

            for (int j = 0; j < n; ++j) {

                if (exist(board, visited, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, int i, int j,
                          String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        visited[i][j] = true;
        boolean existed = exist(board, visited, i-1, j, word, idx+1) ||
                exist(board, visited, i+1, j, word, idx+1) ||
                exist(board, visited, i, j-1, word, idx+1) ||
                exist(board, visited, i, j+1, word, idx+1);
        visited[i][j] = false;
        return existed;
    }
}
