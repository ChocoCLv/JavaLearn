package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void lengthOfLIS() {
        assertEquals(new LongestIncreasingSubsequence()
                .lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4);
    }
}