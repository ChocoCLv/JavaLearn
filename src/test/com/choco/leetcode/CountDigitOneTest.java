package com.choco.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.choco.leetcode.CountDigitOne.Solution;

import static org.junit.Assert.*;

public class CountDigitOneTest {
    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void testCount1() {
        Assert.assertEquals(6, solution.countDigitOne(13));
    }
}