package com.choco.leetcode;

/***
 * Q21 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode r;
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val <= l2.val) {
                r = l1;
                r.next = mergeTwoLists(l1.next, l2);
            } else {
                r = l2;
                r.next = mergeTwoLists(l1, l2.next);
            }
            return r;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode n1 = mtsl.new ListNode(1);
        ListNode n2 = mtsl.new ListNode(2);
        ListNode n3 = mtsl.new ListNode(4);
        ListNode n4 = mtsl.new ListNode(1);
        ListNode n5 = mtsl.new ListNode(3);
        ListNode n6 = mtsl.new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;

        ListNode r = mtsl.new Solution().mergeTwoLists(n1, n4);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }
}
