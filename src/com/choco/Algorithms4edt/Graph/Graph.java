package com.choco.Algorithms4edt.Graph;

import com.choco.Algorithms4edt.DataStructure.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    //顶点数
    public int V() {
        return V;
    }

    //边数
    public int E() {
        return E;
    }

    //向图中添加一条边v-w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    //和v相邻的所有顶点
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
