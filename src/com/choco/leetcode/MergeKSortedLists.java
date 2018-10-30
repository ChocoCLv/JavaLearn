package com.choco.leetcode;


/***
 * Q23 合并k个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return MSort(lists, 0, lists.length - 1);//lists.lengt=k,k个链表头
        }


        public ListNode MSort(ListNode[] lists, int low, int high) {
            if (low < high) {
                int mid = (low + high) / 2;
                ListNode leftlist = MSort(lists, low, mid);
                ListNode rightlist = MSort(lists, mid + 1, high);
                return mergeTwoLists(leftlist, rightlist);
            }

            return lists[low];
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            if (l1.val < l2.val) {
                res = l1;
                l1.next = mergeTwoLists(l1.next, l2);
            } else {
                res = l2;
                l2.next = mergeTwoLists(l1, l2.next);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        Solution solution = mergeKSortedLists.new Solution();
        ListNode node1 = mergeKSortedLists.new ListNode(1);
        ListNode node2 = mergeKSortedLists.new ListNode(4);
        ListNode node3 = mergeKSortedLists.new ListNode(5);
        ListNode node4 = mergeKSortedLists.new ListNode(1);
        ListNode node5 = mergeKSortedLists.new ListNode(3);
        ListNode node6 = mergeKSortedLists.new ListNode(4);
        ListNode node7 = mergeKSortedLists.new ListNode(2);
        ListNode node8 = mergeKSortedLists.new ListNode(6);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        node7.next = node8;
        ListNode r = solution.mergeKLists(new ListNode[]{});
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
