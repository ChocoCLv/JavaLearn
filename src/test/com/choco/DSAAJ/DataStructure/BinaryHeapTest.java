package com.choco.DSAAJ.DataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryHeapTest {

    @Test
    public void testInsert(){
        BinaryHeap bh = new BinaryHeap();
        bh.buildHeap(10);
        bh.insert(3);
        bh.insert(7);
        bh.insert(1);
        bh.insert(2);
        bh.insert(4);
        bh.insert(5);
        assertEquals(bh.data[1].compareTo(new Integer(1)), 0);
    }

    @Test
    public void testDeleteMinOdd(){
        BinaryHeap bh = new BinaryHeap();
        bh.buildHeap(10);
        bh.insert(3);
        bh.insert(7);
        bh.insert(1);
        bh.insert(6);
        bh.insert(2);
        bh.insert(4);
        bh.insert(5);

        assertEquals(bh.deleteMin().compareTo(new Integer(1)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(2)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(3)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(4)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(5)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(6)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(7)),0);

    }

    @Test
    public void testDeleteMinEven(){
        BinaryHeap bh = new BinaryHeap();
        bh.buildHeap(10);
        bh.insert(3);
        bh.insert(7);
        bh.insert(1);
        bh.insert(6);
        bh.insert(2);
        bh.insert(4);
        bh.insert(5);
        bh.insert(8);

        assertEquals(bh.deleteMin().compareTo(new Integer(1)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(2)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(3)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(4)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(5)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(6)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(7)),0);
        assertEquals(bh.deleteMin().compareTo(new Integer(8)),0);

    }
}