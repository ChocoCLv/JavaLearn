package com.choco.offer.Chapter5;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KLeastNumbersInQuickSortTest {

    @Test
    public void getLeastNumbers_Solution() {
        List<Integer> result = new KLeastNumbersInQuickSort().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4);
        for(int n:result)
            System.out.println(n);
    }
}