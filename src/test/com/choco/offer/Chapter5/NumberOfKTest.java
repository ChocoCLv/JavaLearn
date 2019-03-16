package com.choco.offer.Chapter5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfKTest {

    NumberOfK numberOfK;

    @Before
    public void init() {
        numberOfK = new NumberOfK();
    }

    @Test
    public void getNumberOfK() {
        System.out.println(numberOfK.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
    }

    @Test
    public void testFindLower() {
        Assert.assertEquals(numberOfK.findLower(new int[]{1, 2, 4, 5}, 3), 2);
    }

    @Test
    public void testFindUpper() {
        Assert.assertEquals(numberOfK.findUpper(new int[]{1, 2, 4, 5}, 3), 2);
        Assert.assertEquals(numberOfK.findUpper(new int[]{1, 2, 3, 4, 5}, 3), 3);
        Assert.assertEquals(numberOfK.findUpper(new int[]{1, 2, 3, 4, 5}, 5), 5);
    }
}