package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInsertPositionTest {
    @Test
    public void testSearchInsert1(){
        assertEquals(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},5),2);
    }

    @Test
    public void testSearchInsert2(){
        assertEquals(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},2),1);
    }

    @Test
    public void testSearchInsert3(){
        assertEquals(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},7),4);
    }

    @Test
    public void testSearchInsert4(){
        assertEquals(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},0),0);
    }

}