package com.choco.offer.Chapter2;

import com.choco.offer.Chapter2.NextNodeInBinaryTree.BinaryTreeNode;
import org.junit.Test;
import org.junit.Assert;

public class NextNodeInBinaryTreeTest {

    private NextNodeInBinaryTree nextNodeInBinaryTree = new NextNodeInBinaryTree();

    @Test
    public void testGetNext1() {
        BinaryTreeNode a = nextNodeInBinaryTree.new BinaryTreeNode('a');
        BinaryTreeNode b = nextNodeInBinaryTree.new BinaryTreeNode('b');
        BinaryTreeNode c = nextNodeInBinaryTree.new BinaryTreeNode('c');
        BinaryTreeNode d = nextNodeInBinaryTree.new BinaryTreeNode('d');
        BinaryTreeNode e = nextNodeInBinaryTree.new BinaryTreeNode('e');
        BinaryTreeNode f = nextNodeInBinaryTree.new BinaryTreeNode('f');
        BinaryTreeNode g = nextNodeInBinaryTree.new BinaryTreeNode('g');
        BinaryTreeNode h = nextNodeInBinaryTree.new BinaryTreeNode('h');
        BinaryTreeNode i = nextNodeInBinaryTree.new BinaryTreeNode('i');

        a.left = b;
        a.right = c;

        b.father = a;
        b.left = d;
        b.right = e;

        c.father = a;
        c.left = f;
        c.right = g;

        d.father = b;

        e.father = b;
        e.left = h;
        e.right = i;

        f.father = c;

        g.father = c;

        h.father = e;

        i.father = e;

        Assert.assertEquals(nextNodeInBinaryTree.getNext(b),h);
        Assert.assertEquals(nextNodeInBinaryTree.getNext(i),a);
        Assert.assertNull(nextNodeInBinaryTree.getNext(g));
    }

}