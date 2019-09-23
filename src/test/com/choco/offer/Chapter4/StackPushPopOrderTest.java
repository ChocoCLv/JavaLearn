package com.choco.offer.Chapter4;

import org.junit.Assert;
import org.junit.Test;

public class StackPushPopOrderTest {

    @Test
    public void isPopOrder() {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {4, 5, 3, 2, 1};
        int[] s3 = {4, 3, 5, 1, 2};
        int[] s4 = {5, 4, 3, 2, 1};
        int[] s5 = {2, 4, 3, 5, 1};
        Assert.assertTrue(new StackPushPopOrder().isPopOrder(s1, s2));
        Assert.assertTrue(new StackPushPopOrder().isPopOrder(s1, s4));
        Assert.assertTrue(new StackPushPopOrder().isPopOrder(s1, s5));
        Assert.assertFalse(new StackPushPopOrder().isPopOrder(s1, s3));
    }
}