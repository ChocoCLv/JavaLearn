package com.choco.offer.Chapter4;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {

    List<Integer> debug = new ArrayList<>();

    //顺时针打印矩阵的元素
    public void printClockwisely(int[][] matrix) {
        if (matrix == null)
            return;

        int i_start = 0;
        int j_start = 0;
        int i_end = matrix.length - 1;
        int j_end = matrix[0].length - 1;
        while ((i_end - i_start) >= 0 && (j_end - j_start) >= 0) {
            //打印第一行
            for (int j = j_start; j <= j_end; j++) {
                print(matrix[i_start][j]);
            }
            i_start++;
            //打印最后一列
            for (int i = i_start; i <= i_end; i++) {
                print(matrix[i][j_end]);
            }
            j_end--;
            //打印最后一行
            for (int j = j_end; j >= j_start && i_end >= i_start; j--) {
                print(matrix[i_end][j]);
            }
            i_end--;
            //打印第一列
            for (int i = i_end; i >= i_start && j_end >= j_start; i--) {
                print(matrix[i][j_start]);
            }
            j_start++;
        }
        System.out.println();
    }

    private void print(int v) {
        debug.add(v);
        System.out.print(v + " ");
    }
}
