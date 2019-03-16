package com.choco.offer.Chapter4;

public class CopyComplicatedList {
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode node = pHead;
        RandomListNode copyNode;
        RandomListNode copyHead;
        //在原链表的每条next边上加一个点
        while (node != null) {
            copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }

        node = pHead;
        //连接copynode的random
        while (node != null) {
            copyNode = node.next;
            if (node.random != null) {
                copyNode.random = node.random.next;
            }
            node = copyNode.next;
        }

        //拆成两条链表
        node = pHead;
        copyNode = pHead.next;
        copyHead = copyNode;
        while (node != null) {
            node.next = copyNode.next;
            node = node.next;
            if (node != null)
                copyNode.next = node.next;
            copyNode = copyNode.next;
        }
        return copyHead;
    }
}
