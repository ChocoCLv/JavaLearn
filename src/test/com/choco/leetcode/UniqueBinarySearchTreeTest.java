package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreeTest {
    @Test
    public void testNumTrees(){
        assertEquals(new UniqueBinarySearchTree().numTrees(3),5);
        assertEquals(new UniqueBinarySearchTree().numTrees(4),14);
        assertEquals(new UniqueBinarySearchTree().numTrees(5),42);
    }

}