package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringToIntegerTest {

    @Test
    public void myAtoi() {
        assertEquals(new StringToInteger().myAtoi("42"),42);
        assertEquals(new StringToInteger().myAtoi("   -42"),-42);
        assertEquals(new StringToInteger().myAtoi("4193 with words"),4193);
        assertEquals(new StringToInteger().myAtoi("words and 987"),0);
        assertEquals(new StringToInteger().myAtoi("-91283472332"),-2147483648);
    }

    @Test
    public void myAtoi1() {
        assertEquals(new StringToInteger().myAtoi("-2147483649"),-2147483648);
    }
}