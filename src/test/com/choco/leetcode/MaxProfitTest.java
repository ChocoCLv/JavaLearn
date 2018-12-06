package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by choco on 2018/12/6.
 */
public class MaxProfitTest {
    @Test
    public void maxProfit1() throws Exception {
        assertEquals(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}), 5);
    }

    @Test
    public void maxProfit2() throws Exception {
        assertEquals(new MaxProfit().maxProfit(new int[]{7,6,4,3,1}), 0);
    }

}