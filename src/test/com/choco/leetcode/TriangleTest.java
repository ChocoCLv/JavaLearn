package com.choco.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void minimumTotal1() {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(2));
        l.add(Arrays.asList(3,4));
        l.add(Arrays.asList(6,5,7));
        l.add(Arrays.asList(4,1,8,3));
        assertEquals(new Triangle().minimumTotal(l),11);
    }

    @Test
    public void minimumTotal2() {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(2));
        assertEquals(new Triangle().minimumTotal(l),2);
    }
}