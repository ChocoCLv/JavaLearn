package com.choco.offer.Chapter4;

/**
 * 验证一个序列是否可能为一个二叉搜索树的后序遍历序列
 */
public class SequenceOfBST {
    public boolean validate(int[] seq) {
        return validateCore(seq, 0, seq.length - 1);
    }

    private boolean validateCore(int[] seq, int start, int end) {
        if (seq == null || start > end)
            return false;
        if (start == end)
            return true;
        int root = seq[end];
        int leftRoot = start;
        //这样找出来的是右子树的第一个节点
        while (seq[leftRoot] < root) leftRoot++;
        leftRoot--;
        for (int i = leftRoot + 1; i <= end; i++) {
            if (seq[i] < root)
                return false;
        }
        boolean result = true;
        if (leftRoot >= start)
            result = validateCore(seq, start, leftRoot);
        if (leftRoot + 1 < end)
            result = result && validateCore(seq, leftRoot + 1, end - 1);
        return result;
    }

}
