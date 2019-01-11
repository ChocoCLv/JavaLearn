package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToRomanTest {
    @Test
    public void testIntToRoman1(){
        assertEquals(new IntegerToRoman().intToRoman(3),"III");
    }

    @Test
    public void testIntToRoman2(){
        assertEquals(new IntegerToRoman().intToRoman(4),"IV");
    }

    @Test
    public void testIntToRoman3(){
        assertEquals(new IntegerToRoman().intToRoman(9),"IX");
    }

    @Test
    public void testIntToRoman4(){
        assertEquals(new IntegerToRoman().intToRoman(58),"LVIII");
    }

    @Test
    public void testIntToRoman5(){
        assertEquals(new IntegerToRoman().intToRoman(1994),"MCMXCIV");
    }

}