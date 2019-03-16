package com.choco.offer.Chapter2;

import org.junit.Assert;
import org.junit.Test;

public class MinNumberInRotatedArrayTest {

    @Test
    public void test() {
        Assert.assertEquals(MinNumberInRotatedArray.searchMinIndex(new int[]{4, 5, 6, 7, 0, 1, 2}), 4);
        Assert.assertEquals(MinNumberInRotatedArray.searchMinIndex(new int[]{1, 1, 1, 0, 1}), 3);
        Assert.assertEquals(MinNumberInRotatedArray.searchMinIndex(new int[]{1, 0, 1, 1, 1}), 1);
        Assert.assertEquals(MinNumberInRotatedArray.searchMinIndex(new int[]{1, 2, 3, 4, 5}), 0);
    }
}