package com.choco.coursera.ElementarySorts;

public class ShellSort implements Sortable {
    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5, 3};
        Sortable shell = new ShellSort();
        shell.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(Comparable[] datas) {
        int N = datas.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = 0; i < N; i++) {
                for (int j = i; j > 0; j -= h) {
                    if (Sortable.less(datas[j], datas[j - 1])) {
                        Sortable.swap(datas, j - 1, j);
                    } else {
                        break;
                    }
                }
            }
            h /= 3;
        }
    }
}
