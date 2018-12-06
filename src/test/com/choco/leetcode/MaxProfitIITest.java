package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by choco on 2018/12/6.
 */
public class MaxProfitIITest {
    @Test
    public void maxProfit1() throws Exception {
        assertEquals(new MaxProfitII().maxProfit(new int[]{7,1,5,3,6,4}),7);
    }

    @Test
    public void maxProfit2() throws Exception {
        assertEquals(new MaxProfitII().maxProfit(new int[]{1,2,3,4,5}),4);
    }

    @Test
    public void maxProfit3() throws Exception {
        assertEquals(new MaxProfitII().maxProfit(new int[]{7,6,4,3,1}),0);
    }

    @Test
    public void maxProfit4() throws Exception {
        assertEquals(new MaxProfitII().maxProfit(new int[]{}),0);
    }
}