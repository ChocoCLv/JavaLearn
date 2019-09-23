package com.choco.offer.Chapter4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceOfBSTTest {

    @Test
    public void validate() {
        Assert.assertTrue(new SequenceOfBST().validate(new int[]{5,7,6,9,11,10,8}));
        Assert.assertFalse(new SequenceOfBST().validate(new int[]{7,4,6,5}));
    }
}