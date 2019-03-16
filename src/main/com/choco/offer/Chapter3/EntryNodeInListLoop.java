package com.choco.offer.Chapter3;


/**
 * 找到链表中环的入口节点
 * 1. 先确定链表中是否存在环
 * 2. 找到环的长度n
 * 3. 使用双指针p q，p先前进n步后q再出发，p q相遇的这个节点即为入口节点
 */
public class EntryNodeInListLoop {

    public ListNode entryNodeOfLoop(ListNode head) {
        ListNode nodeInLoop = findNodeInLoop(head);
        if (nodeInLoop == null)
            return null;

        int loopLength = getLengthOfLoop(nodeInLoop);

        ListNode p = head;
        ListNode q = head;

        while (loopLength-- != 0) {
            p = p.next;
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public int getLengthOfLoop(ListNode nodeInLoop) {
        int loopLength = 1;
        ListNode otherNodeInLoop = nodeInLoop.next;
        while (otherNodeInLoop != nodeInLoop) {
            otherNodeInLoop = otherNodeInLoop.next;
            loopLength++;
        }
        return loopLength;
    }

    public ListNode findNodeInLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }
}
