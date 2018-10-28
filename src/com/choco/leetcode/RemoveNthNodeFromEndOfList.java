package com.choco.leetcode;

/***
 * Q19 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 */

public class RemoveNthNodeFromEndOfList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fake = new ListNode(0);
            fake.next = head;
            ListNode i = fake;
            ListNode j = head;
            while (--n > 0) {
                j = j.next;
            }
            while (j != null && j.next != null) {
                i = i.next;
                j = j.next;
            }
            i.next = i.next.next;
            return fake.next;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode node1 = removeNthNodeFromEndOfList.new ListNode(1);
        ListNode node2 = removeNthNodeFromEndOfList.new ListNode(2);
        ListNode node3 = removeNthNodeFromEndOfList.new ListNode(3);
        ListNode node4 = removeNthNodeFromEndOfList.new ListNode(4);
        ListNode node5 = removeNthNodeFromEndOfList.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = removeNthNodeFromEndOfList.new Solution();
        ListNode node = solution.removeNthFromEnd(node1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
