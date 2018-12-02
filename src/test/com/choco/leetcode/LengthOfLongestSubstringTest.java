package com.choco.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLongestSubstringTest {
    LengthOfLongestSubstring lols;

    @Before
    public void setUp() {
        lols = new LengthOfLongestSubstring();
    }

    @Test
    public void testLengthOfLongestSubstring1() {
        assertEquals(lols.lengthOfLongestSubstring("abcabcbb"), 3);
    }

    @Test
    public void testLengthOfLongestSubstring2() {
        assertEquals(lols.lengthOfLongestSubstring("bbbbb"), 1);
    }

    @Test
    public void testLengthOfLongestSubstring3() {
        assertEquals(lols.lengthOfLongestSubstring("pwwkew"), 3);
    }

    @Test
    public void testLengthOfLongestSubstring4() {
        assertEquals(lols.lengthOfLongestSubstring(""), 0);
    }

    @Test
    public void testLengthOfLongestSubstring5() {
        assertEquals(lols.lengthOfLongestSubstring("dvdf"), 3);
    }
}