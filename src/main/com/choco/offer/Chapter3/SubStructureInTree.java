package com.choco.offer.Chapter3;

public class SubStructureInTree {
    /**
     * 判断t2是否存在于t1
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean hasSubtree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null || t2 == null)
            return false;
        boolean result = false;
        if (t1.val == t2.val)
            result = doesHasSubtree(t1, t2);
        if (!result)
            result = hasSubtree(t1.left, t2);
        if (!result)
            result = hasSubtree(t1.right, t2);
        return result;
    }

    private boolean doesHasSubtree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return doesHasSubtree(t1.left, t2.left) && doesHasSubtree(t1.right, t2.right);
    }
}
