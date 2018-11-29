package com.choco.coursera.ElementarySorts;

public class MergeBUSort extends MergeSort {
    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5, 3};
        Sortable mergeBU = new MergeBUSort();
        mergeBU.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(Comparable[] a) {
        System.out.println("Merge Bottom Up sort:");
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 2; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }

}
