package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenLinkedListTest {

    @Test
    public void oddEvenList() {
        OddEvenLinkedList oel = new OddEvenLinkedList();
        OddEvenLinkedList.ListNode head = oel.new ListNode(1);
        head.next = oel.new ListNode(2);
        head.next.next = oel.new ListNode(3);
        //head.next.next.next = oel.new ListNode(4);


        OddEvenLinkedList.ListNode node = oel.oddEvenList(head);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}