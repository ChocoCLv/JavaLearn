package com.choco.ByteDance;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubStringTest {

    @Test
    public void testGenerateSubstring() {
        SubString ss = new SubString();
        Map<Integer, Set<SubString.SuperString>> substrings = ss.generateSubstring("abcd");
        for (Integer i : substrings.keySet()) {
            for (SubString.SuperString superS : substrings.get(i)) {
                System.out.print(superS.s + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testIsDirectedInjection(){
        SubString ss = new SubString();
        assertFalse(ss.isDirectedInjection("abac","bbcd"));
        assertFalse(ss.isDirectedInjection("bbcd","abac"));
    }

    @Test
    public void testIsIsomorphic(){
        SubString ss = new SubString();
        //assertFalse(ss.isIsomorphic("abac","bbcd"));
        assertTrue(ss.isIsomorphic("ab","bc"));
    }

    @Test
    public void testGetMaxNotIsomorphicNum(){
        SubString ss = new SubString();
        assertEquals(ss.getMaxNotIsomorphicNum("abcd"),4);
        assertEquals(ss.getMaxNotIsomorphicNum("abaa"),6);
    }
}