package com.choco.offer.Chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {
    RegularExpressionMatching rem;
    @Before
    public void setUp() {
         rem = new RegularExpressionMatching();
    }

    @Test
    public void testIsMatch1() {
        assertTrue(rem.isMatch("", "c*c*"));
    }

    @Test
    public void testIsMatch2() {
        assertFalse(rem.isMatch("aa", "a"));
    }

    @Test
    public void testIsMatch3() {
        assertTrue(rem.isMatch("aa", "a*"));
    }

    @Test
    public void testIsMatch4() {
        assertTrue(rem.isMatch("ab", ".*"));
    }

    @Test
    public void testIsMatch5() {
        assertTrue(rem.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testIsMatch6() {
        assertFalse(rem.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void testIsMatch7() {
        assertTrue(rem.isMatch("a", ".*"));
    }

    @Test
    public void testIsMatch8() {
        assertFalse(rem.isMatch("bb", "..*c"));
    }

    @Test
    public void testIsMatch9() {
        assertFalse(rem.isMatch("a", ".*..a"));
    }

}