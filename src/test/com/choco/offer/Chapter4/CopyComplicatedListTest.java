package com.choco.offer.Chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class CopyComplicatedListTest {

    @Test
    public void Clone() {
        CopyComplicatedList copyComplicatedList = new CopyComplicatedList();
        CopyComplicatedList.RandomListNode node = copyComplicatedList.new RandomListNode(1);
        node.next = copyComplicatedList.new RandomListNode(2);
        node.next.next = copyComplicatedList.new RandomListNode(3);
        node.random = node.next.next;
        CopyComplicatedList.RandomListNode copy = copyComplicatedList.Clone(node);
    }
}