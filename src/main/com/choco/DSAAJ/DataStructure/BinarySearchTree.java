package com.choco.DSAAJ.DataStructure;

public class BinarySearchTree<T extends Comparable<? super T>> {


    public BinaryNode<T> root;

    public void insert(BinaryNode<T> x){
        BinaryNode<T> node = root;
        if (root == null) {
            root = new BinaryNode<>(x);
            return;
        }
        while (true) {
            if (node.element.compareTo(x.element) < 0) {
                if (node.right == null) {
                    node.right = new BinaryNode<>(x);
                    return;
                }
                if (node.right.element.compareTo(x.element) < 0) {
                    node = node.right;
                    continue;
                }
                BinaryNode<T> tmp = node.right;
                node.right = new BinaryNode<>(x, null, tmp);
                return;
            } else {
                if (node.left == null) {
                    node.left = new BinaryNode<>(x);
                    return;
                }
                if (node.left.element.compareTo(x.element) > 0) {
                    node = node.left;
                    continue;
                }
                BinaryNode<T> tmp = node.left;
                node.left = new BinaryNode<>(x, tmp, null);
                return;
            }
        }
    }

    public void insert(T x) {
        insert(new BinaryNode<>(x));
    }

    public boolean contains(T x) {
        return contains(root, x);
    }

    private boolean contains(BinaryNode<T> root, T x) {
        if (root == null)
            return false;
        if (root.element.compareTo(x) == 0)
            return true;
        else if (root.element.compareTo(x) > 0)
            return contains(root.left, x);
        else
            return contains(root.right, x);
    }

    public void remove(T x) {
        BinaryNode<T> father = root;
        remove(root,x);
    }

    private BinaryNode<T> remove(BinaryNode<T> node,T x){
        if(node == null)
            return node;

        int compareResult = x.compareTo(node.element);

        if(compareResult<0){
            node.left=remove(node.left,x);
        }else if(compareResult>0){
            node.right=remove(node.right,x);
        }else if(node.left!=null&&node.right!=null){
            node.element=findMin(node.right).element;
            node.right=remove(node.right,node.element);
        }else{
            node = (node.left!=null)?node.left:node.right;
        }
        return node;
    }

    public BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null)
            return null;

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
