package com.choco.offer.Chapter2;

import org.junit.Assert;
import org.junit.Test;

public class StringPathInMatrixTest {

    @Test
    public void testHasPath() {
        String s = "bfce";
        char[][] matrix = new char[][]{
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        Assert.assertTrue(new StringPathInMatrix().hasPath(matrix, s));
    }
}