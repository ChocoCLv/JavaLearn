package com.choco.leetcode;

/***
 * Q37 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        boolean[][][] used = new boolean[9][9][9];
        init(board, used);
        dfs(board, 0, 0, used);
    }

    private void init(char[][] board, boolean[][][] used) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                markCell(used, i, j, board[i][j]);
            }
        }
    }

    private void markCell(boolean[][][] used, int i, int j, char c) {
        //mark row i
        for (int column = 0; column < 9; column++) {
            used[i][column][c - '1'] = true;
        }
        //mark column j
        for (int row = 0; row < 9; row++) {
            used[row][j][c - '1'] = true;
        }
        //mark square
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; ++row) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; ++col) {
                used[row][col][c - '1'] = true;
            }
        }
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][][] used) {
        if (i == 9)
            return true;
        if (j == 9)
            return dfs(board, i + 1, 0, used);
        if (board[i][j] != '.')
            return dfs(board, i, j + 1, used);
        for (int k = 0; k < 9; k++) {
            //尝试一种解法
            if(used[i][j][k])
                continue;
            char c = (char) ('1' + k);
            board[i][j] = c;
            //如果有效则进行下一步尝试
            if (isValid(board, i, j)) {
                if (dfs(board, i, j + 1, used))
                    return true;
            }
            //否则放弃这种解法，还原board[i][j]
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int col = 0; col < 9; ++col) {
            if (col != j && board[i][j] == board[i][col]) return false;
        }
        for (int row = 0; row < 9; ++row) {
            if (row != i && board[i][j] == board[row][j]) return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; ++row) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; ++col) {
                if ((row != i || col != j) && board[i][j] == board[row][col]) return false;
            }
        }
        return true;
    }
}
