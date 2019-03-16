package com.choco.offer.Chapter3;

public class DeleteDuplicatedNode {

    public ListNode deleteDuplicatedNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fakeHead = new ListNode(1);
        fakeHead.next = head;
        ListNode last = fakeHead;
        ListNode current = head;
        ListNode next = head.next;
        boolean needDelete = false;
        while (next != null) {
            if (current.val == next.val) {
                needDelete = true;
                if (next.next == null) {
                    last.next = null;
                    break;
                }
            } else if (needDelete) {
                last.next = next;
                needDelete = false;
            } else {
                last = last.next;
            }
            current = current.next;
            next = next.next;
        }
        return fakeHead.next;
    }
}
