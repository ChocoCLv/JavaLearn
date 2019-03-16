package com.choco.offer.Chapter3;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedListTest {

    @Test
    public void merge() {
        ListNode l1 = new ListNode(0);
        l1.addNext(2).addNext(4).addNext(6);
        ListNode l2 = new ListNode(1);
        l2.addNext(3).addNext(5).addNext(7);
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        mergeTwoSortedList.merge(l1,l2).print();
    }
}