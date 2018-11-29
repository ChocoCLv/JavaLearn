package com.choco.coursera.Intro;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionFind {
    private int[] data;
    private int[] weight;

    //initialize union-find data structure with N objects (0 to N-1)
    UnionFind(int N) {
        data = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = i;
            weight[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        UnionFind uf = new UnionFind(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }

    //add connection between p and q
    //连接两棵树时考虑树的大小 将小树作为大树的子树，防止过深
    void union(int p, int q) {

        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (weight[i] > weight[j]) {
            data[j] = i;
            weight[i] += weight[j];
        } else {
            data[i] = j;
            weight[j] += weight[i];
        }
    }

    //are p and q in the same component
    boolean connected(int p, int q) {
        //return data[p] == data[q];
        return root(p) == root(q);
    }

    //component identifier for p (0 to N-11)
    int find(int p) {
        return data[p];
    }

    //number of components
    int count() {
        Set<Integer> components = new HashSet<>();
        for (int d : data) {
            components.add(d);
        }
        return components.size();
    }

    private int root(int i) {
        while (i != data[i]) {
            data[i] = data[data[i]];//flat the tree
            i = data[i];
        }
        return i;
    }
}
