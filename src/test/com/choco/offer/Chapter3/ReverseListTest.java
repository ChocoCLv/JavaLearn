package com.choco.offer.Chapter3;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseListTest {

    @Test
    public void reverseList() {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(0);
        head.addNext(1).addNext(2).addNext(3).addNext(4);
        reverseList.reverseList(head).print();
    }
}