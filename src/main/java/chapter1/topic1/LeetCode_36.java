package chapter1.topic1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2020/5/20
 *
 * 36. Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * 题意：
 * 每一行、每一列、每一个小正方形，不出现重复数字即可。
 *
 *
 * 思路：
 * 1. 每一行、每一列、每一个小正方形逐一判断，是否有重复的
 *
 * 2. 用 3 维数组来记录，行、列、小正方形的数字是否重复
 *
 */
public class LeetCode_36 {

    // Time: O(n ^ 2), Space: O(n), Faster: 82.23%
    public boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            set.clear();
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j])) return false;
            }
            set.clear();
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] == '.') continue;
                if (!set.add(board[j][i])) return false;
            }
            set.clear();
            for (int j = 0; j < 9; ++j) {
                int r = 3*(i/3) + j/3, c = 3*(i%3) + j%3;
                if (board[r][c] == '.') continue;
                if (!set.add(board[r][c])) return false;
            }
        }
        return true;
    }

    // Time: O(n ^ 2), Space: O(n ^ 2), Faster: 100.00%
    public boolean isValidSudoku2DArray(char[][] board) {
        boolean[][] rowSeen = new boolean[9][9];
        boolean[][] colSeen = new boolean[9][9];
        boolean[][] boxSeen = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int x = board[i][j] - '1';
                int k = (i/3) * 3 + j/3;
                if (rowSeen[i][x] || colSeen[j][x] || boxSeen[k][x])
                    return false;
                rowSeen[i][x] = true;
                colSeen[j][x] = true;
                boxSeen[k][x] = true;
            }
        }
        return true;
    }
}
