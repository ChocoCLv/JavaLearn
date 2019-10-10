package com.choco.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsNearbyAlmostDuplicateTest {
    ContainsNearbyAlmostDuplicate.Solution solution;

    @Before
    public void init() {
        solution = new ContainsNearbyAlmostDuplicate.Solution();
    }

    @Test
    public void testSolution() {
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

}