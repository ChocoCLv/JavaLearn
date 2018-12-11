package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by choco on 2018/12/6.
 */
public class MaxProfitIIITest {
    @Test
    public void maxProfit1() throws Exception {
        assertEquals(new MaxProfitIII().maxProfit(new int[]{3,3,5,0,0,3,1,4}),6);
    }

    @Test
    public void maxProfit2() throws Exception {
        assertEquals(new MaxProfitIII().maxProfit(new int[]{1,2,3,4,5}),4);
    }

    @Test
    public void maxProfit3() throws Exception {
        assertEquals(new MaxProfitIII().maxProfit(new int[]{7,6,4,3,1}),0);
    }

    @Test
    public void maxProfit4() throws Exception {
        assertEquals(new MaxProfitIII().maxProfit(new int[]{}),0);
    }

    @Test
    public void maxProfit5() throws Exception {
        assertEquals(new MaxProfitIII().maxProfit(new int[]{3,2,6,5,0,3}),7);
    }
}