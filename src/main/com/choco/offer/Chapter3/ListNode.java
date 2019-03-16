package com.choco.offer.Chapter3;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
        this.val = v;
    }

    ListNode addNext(int v) {
        this.next = new ListNode(v);
        return this.next;
    }

    ListNode addNext(ListNode node) {
        this.next = node;
        return this.next;
    }

    void print() {
        System.out.print(val + " ");
        if (next != null)
            next.print();
    }
}
