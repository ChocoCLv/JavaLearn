package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by choco on 2018/12/11.
 */
public class MaximalSquareTest {
    @Test
    public void maximalSquare1() {
        assertEquals(new MaximalSquare().maximalSquare(new char[][]{}), 0);
    }

    @Test
    public void maximalSquare2() {
        assertEquals(
                new MaximalSquare().maximalSquare(
                        new char[][]{
                                {'1', '0', '1', '0', '0'},
                                {'1', '0', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'},
                                {'1', '0', '0', '1', '0'}}),
                4);
    }

    @Test
    public void maximalSquare3() {
        assertEquals(
                new MaximalSquare().maximalSquare(
                        new char[][]{
                                {'1'}
                        }),
                1);
    }

    @Test
    public void maximalSquare4() {
        assertEquals(
                new MaximalSquare().maximalSquare(
                        new char[][]{
                                {'0', '0', '0', '1'},
                                {'1', '1', '0', '1'},
                                {'1', '1', '1', '1'},
                                {'0', '1', '1', '1'},
                                {'0', '1', '1', '1'}}),
                9);
    }

    @Test
    public void maximalSquare5() {
        assertEquals(
                new MaximalSquare().maximalSquare(
                        new char[][]{
                                {'1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','0'},
                                {'1','1','1','1','1','1','1','0'},
                                {'1','1','1','1','1','0','0','0'},
                                {'0','1','1','1','1','0','0','0'}}),
                16);
    }
}