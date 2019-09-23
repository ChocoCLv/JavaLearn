package com.choco.offer.Chapter4;

import org.junit.Test;

public class PrintMatrixTest {

    @Test
    public void printClockwisely() {
        int[][] matrix1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        new PrintMatrix().printClockwisely(matrix1);

        int[][] matrix2 = {{1,2,3,4}};
        new PrintMatrix().printClockwisely(matrix2);

        int[][] matrix3 = {{1},{2},{3}};
        new PrintMatrix().printClockwisely(matrix3);

    }
}