package com.choco.coursera.ElementarySorts;

/*
    选择排序
    i从0开始计数
    在第i次迭代中 data[i]左边的数有序，并找到data[i]右边的最小值的位置，与data[i]交换位置
 */
public class SelectionSort implements Sortable {

    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5, 3};
        Sortable selection = new SelectionSort();
        selection.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(Comparable[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int min = i;
            for (int j = i + 1; j < datas.length; j++) {
                if (Sortable.less(datas[j], datas[min])) {
                    min = j;
                }
            }
            Sortable.swap(datas, i, min);
        }
    }

}
