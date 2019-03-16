package com.choco.offer.Chapter3;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        ListNode reversedHead = null;
        while (current != null) {
            next = current.next;
            if (next == null) {
                reversedHead = current;
            }
            current.next = prev;
            prev = current;
            current = next;
        }
        return reversedHead;
    }
}
