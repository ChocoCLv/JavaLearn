package com.choco.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateStackSequencesTest {
    private ValidateStackSequences.Solution solution;

    @Before
    public void init() {
        solution = new ValidateStackSequences.Solution();
    }

    @Test
    public void validate() {
        Assert.assertTrue(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        Assert.assertFalse(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}