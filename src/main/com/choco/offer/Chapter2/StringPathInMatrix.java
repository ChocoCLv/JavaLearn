package com.choco.offer.Chapter2;

public class StringPathInMatrix {

    /**
     * 判断字符矩阵中是否存在一条包含某字符串所有字符的路径，且不包含其他字符
     *
     * @param matrix
     * @param s
     * @return
     */
    public boolean hasPath(char[][] matrix, String s) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (hasPath(matrix, s, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPath(char[][] matrix, String s, int row, int column, int step, boolean[][] visited) {
        if (s.length() == step)
            return true;
        int M = matrix.length;
        int N = matrix[0].length;
        if (row < M && column < N && row >= 0 && column >= 0 &&
                visited[row][column] == false && matrix[row][column] == s.charAt(step)) {
            visited[row][column] = true;
            if (hasPath(matrix, s, row + 1, column, step + 1, visited)
                    || hasPath(matrix, s, row - 1, column, step + 1, visited)
                    || hasPath(matrix, s, row, column + 1, step + 1, visited)
                    || hasPath(matrix, s, row, column - 1, step + 1, visited)) {
                return true;
            }
            visited[row][column] = false;
        }
        return false;
    }
}
