package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void testSearchRange1() {
        assertArrayEquals(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5,7,7,8,8,10},8),new int[]{3,4});
    }

    @Test
    public void testSearchRange2() {
        assertArrayEquals(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5,7,7,8,8,10},6),new int[]{-1,-1});
    }
}