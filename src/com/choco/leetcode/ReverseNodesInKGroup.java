package com.choco.leetcode;

/**
 * Created by choco on 2018/11/6.
 * Q25 k个一组翻转链表
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

 示例 :

 给定这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        private ListNode newHead;
        private ListNode next;

        public ListNode reverseKGroup(ListNode head, int k) {
            return traval(head, k);
        }

        private ListNode traval(ListNode node, int k) {
            if (node == null)
                return null;
            reverse(node, k);
            ListNode tmp = newHead;
            if (tmp == null)
                return node;
            node.next = traval(next, k);
            return tmp;
        }

        public ListNode reverse(ListNode start, int k) {
            if (k == 1 || start == null) {
                newHead = start;
                if (start != null)
                    next = start.next;
                else
                    next = null;
                return start;
            }
            ListNode node = reverse(start.next, k - 1);
            if (node == null) {
                return null;
            }
            node.next = start;
            return start;
        }
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup rnikg = new ReverseNodesInKGroup();
        Solution solution = rnikg.new Solution();
        ListNode node1 = rnikg.new ListNode(1);
        ListNode node2 = rnikg.new ListNode(2);
        ListNode node3 = rnikg.new ListNode(3);
        ListNode node4 = rnikg.new ListNode(4);
        ListNode node5 = rnikg.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = solution.reverseKGroup(node2, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
