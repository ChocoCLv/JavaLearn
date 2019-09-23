package com.choco.offer.Chapter2;

import java.util.Objects;

public class NextNodeInBinaryTree {
    /**
     * 节点包含了左右子节点和父节点。
     *
     * @param node 二叉树中的一个节点
     * @return 该节点在二叉树中序遍历的下一个节点。
     */
    public BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null)
            return null;

        //1. 如果该节点有右子树，则下一个节点为右子树的最左节点
        if (node.right != null) {
            BinaryTreeNode tmp = node.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        }

        //2. 节点没有右子树
        //2.1 节点没有父节点，则该节点为二叉树中序遍历的最后一个节点
        if (node.father == null)
            return null;
        //2.2 节点是父节点的左子树，下一个节点为父节点
        if (node.equals(node.father.left))
            return node.father;
            //2.3 节点是父节点的右子树，下一个节点为：从该节点一直向上搜索，直到某个节点为父节点的左子节点,那么这个节点的父节点即为下一个节点
        else {
            BinaryTreeNode father = node.father;
            BinaryTreeNode current = node;
            while (father != null && !current.equals(father.left)) {
                current = father;
                father = father.father;
            }
            return father;
        }

    }

    class BinaryTreeNode {
        char val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode father;

        public BinaryTreeNode(char val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BinaryTreeNode)) return false;
            BinaryTreeNode that = (BinaryTreeNode) o;
            return val == that.val &&
                    Objects.equals(left, that.left) &&
                    Objects.equals(right, that.right) &&
                    Objects.equals(father, that.father);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right, father);
        }
    }
}
