package com.choco.Algorithms4edt.UndirectedGraph;

import com.choco.Algorithms4edt.DataStructure.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;
    private Bag<Integer>[] cc_id;

    public ConnectedComponents(Graph G) {
        count = 0;
        id = new int[G.V()];
        marked = new boolean[G.V()];
        cc_id = new Bag[G.V()];

        for (int w = 0; w < G.V(); w++) {
            cc_id[count] = new Bag<>();
            if (!marked[w]) {
                dfs(G, w);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));

        ConnectedComponents cc = new ConnectedComponents(G);
        StdOut.println(cc.count() + " components");
        for (int id = 0; id < cc.count(); id++) {
            for (int w : cc.cc_id[id]) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }

    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        cc_id[count].add(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

}
