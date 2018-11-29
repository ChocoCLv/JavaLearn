package com.choco.leetcode;

/**
 * Q24 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     ***/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归版本
    class Solution {
        public ListNode swapPairs(ListNode head) {
            return traval(head);
        }

        private ListNode traval(ListNode node) {
            if (node == null)
                return null;
            if (node.next == null)
                return node;
            ListNode tmp = node.next;
            node.next = traval(tmp.next);
            tmp.next = node;
            return tmp;
        }
    }

    //非递归版本
    class Solution1 {
        public ListNode swapPairs(ListNode head) {

            ListNode pointC = new ListNode(0);
            if (head == null || head.next == null) return head;
            pointC.next = head;
            ListNode pointA = pointC;
            while (head.next != null && head.next.next != null) {


                pointA.next = head.next;
                head.next = head.next.next;
                pointA.next.next = head;
                pointA = pointA.next.next;
                head = pointA.next;

            }
            if (head.next != null) {
                pointA.next = head.next;
                head.next = head.next.next;
                pointA.next.next = head;
            }
            return pointC.next;
        }
    }

    public static void main(String[] args) {
        SwapNodesInPairs snip = new SwapNodesInPairs();
        Solution solution = snip.new Solution();

        ListNode node1 = snip.new ListNode(1);
        ListNode node2 = snip.new ListNode(2);
        ListNode node3 = snip.new ListNode(3);
        ListNode node4 = snip.new ListNode(4);
        ListNode node5 = snip.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = solution.swapPairs(node5.next);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
