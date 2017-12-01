package com.choco.leetcode;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Add2Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode result;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        Add2Numbers solution = new Add2Numbers();
        result = solution.addTwoNumbers(l1, l2);
        solution.printListNode(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Cursor = l1;
        ListNode l2Cursor = l2;
        int carry = 0;
        int tmpResult;

        while (true) {

            tmpResult = (l1Cursor.val + l2Cursor.val + carry) % 10;
            carry = (l1Cursor.val + l2Cursor.val + carry) / 10;
            l2Cursor.val = tmpResult;
            if (l1Cursor.next == null && l2Cursor.next == null) {
                break;
            }
            if (l1Cursor.next == null) {
                l1Cursor.next = new ListNode(0);
            }
            if (l2Cursor.next == null) {
                l2Cursor.next = new ListNode(0);
            }
            l1Cursor = l1Cursor.next;
            l2Cursor = l2Cursor.next;
        }


        if (carry != 0) {
            l2Cursor.next = new ListNode(carry);
        }

        return l2;
    }

    public void printListNode(ListNode l) {
        ListNode p = l;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
    }
}
