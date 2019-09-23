package com.choco.offer.Chapter3;

public class MergeTwoSortedList {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode mergedHead = null;
        if (l1.val < l2.val) {
            mergedHead = l1;
            mergedHead.next = merge(l1.next, l2);
        } else {
            mergedHead = l2;
            mergedHead.next = merge(l1, l2.next);
        }
        return mergedHead;
    }
}
