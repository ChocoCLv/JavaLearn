package com.choco.coursera.ElementarySorts;

public class MergeSort implements Sortable {
    private Comparable[] aux;

    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5, 3};
        Sortable merge = new MergeSort();
        merge.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(Comparable[] datas) {
        aux = new Comparable[datas.length];
        sort(datas, aux, 0, datas.length - 1);
    }

    public void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert Sortable.isSorted(a, lo, mid);
        assert Sortable.isSorted(a, mid + 1, hi);
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (Sortable.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (!Sortable.less(a[mid + 1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }
}
