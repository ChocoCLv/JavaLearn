package com.choco.coursera.ElementarySorts;

/*
    插入排序
    i从0开始
    在第i次迭代中，第i个数左边的数列有序，将0~i-1的数列与i一起组成新序列，将i插入到合适的位置
 */
public class InsertionSort implements Sortable {
    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5, 3};
        Sortable insertion = new InsertionSort();
        insertion.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(Comparable[] datas) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = i; j > 0; j--) {
                if (Sortable.less(datas[j], datas[j - 1])) {
                    Sortable.swap(datas, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

}
