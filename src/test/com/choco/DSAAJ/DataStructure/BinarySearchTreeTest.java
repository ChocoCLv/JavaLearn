package com.choco.DSAAJ.DataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest<T extends Comparable<? super T>> {
    @Test
    public void testInsert(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        createBinaryIntegerSearchTree(bst,200);
        isSorted(bst.root);
    }

    @Test
    public void testContains(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0;i<20;i++){
            bst.insert(new BinaryNode<>(i));
        }

        assertTrue(bst.contains(10));
        assertFalse(bst.contains(20));
    }

    @Test
    public void testFindMin(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0;i<20;i++){
            bst.insert(new BinaryNode<>(i));
        }

        assertTrue(bst.findMin(bst.root).element==0);
    }

    @Test
    public void testFindMax(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0;i<20;i++){
            bst.insert(new BinaryNode<>(i));
        }

        assertTrue(bst.findMax(bst.root).element==19);
    }

    @Test
    public void testRemove(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0;i<20;i++){
            bst.insert(new BinaryNode<>(i));
        }
        bst.remove(10);
        isSorted(bst.root);
        assertFalse(bst.contains(10));
    }

    private void createBinaryIntegerSearchTree(BinarySearchTree<Integer> bst,int size){
        while(size--!=0){
            bst.insert(BinaryNode.randomIntegerGenerator.next());
        }
    }

    private void isSorted(BinaryNode<Integer> root){
        if(root==null)
            return;
        if(root.left!=null){
            assertTrue(root.element.compareTo(root.left.element)>=0);
            isSorted(root.left);
        }
        if(root.right!=null){
            assertTrue(root.element.compareTo(root.right.element)<=0);
            isSorted(root.right);
        }
    }

}