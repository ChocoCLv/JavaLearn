package com.choco.offer.Chapter3;

import org.junit.Test;

public class DeleteDuplicatedNodeTest {

    @Test
    public void deleteDuplicatedNode() {
        DeleteDuplicatedNode deleteDuplicatedNode = new DeleteDuplicatedNode();
        ListNode head = new ListNode(1);
        head.addNext(1)
                //.addNext(2)
                .addNext(3)
                .addNext(3)
                //.addNext(4)
                .addNext(5)
                .addNext(5);
        ListNode result = deleteDuplicatedNode.deleteDuplicatedNode(head);
        if (result != null)
            result.print();
    }
}