package com.choco.offer.Chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntryNodeInListLoopTest {

    ListNode head;
    ListNode entry;
    EntryNodeInListLoop entryNodeInListLoop;

    @Before
    public void init() {
        entryNodeInListLoop = new EntryNodeInListLoop();
        head = new ListNode(1);
        entry = head.addNext(2).addNext(3);
        entry.addNext(4).addNext(5).addNext(6).addNext(entry);
    }

    @Test
    public void entryNodeOfLoop() {
        Assert.assertEquals(entryNodeInListLoop.entryNodeOfLoop(head), entry);
    }

    @Test
    public void findNodeInLoop() {
        System.out.println(entryNodeInListLoop.findNodeInLoop(head).val);
    }

    @Test
    public void getLengthOfLoop() {
        Assert.assertEquals(entryNodeInListLoop.getLengthOfLoop(entryNodeInListLoop.findNodeInLoop(head)), 4);
    }
}