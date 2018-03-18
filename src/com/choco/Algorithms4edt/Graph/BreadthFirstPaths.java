package com.choco.Algorithms4edt.Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths extends Paths {

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);

        Paths search = new BreadthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s)
                        StdOut.print(x);
                    else
                        StdOut.print("-" + x);
                }
            }
            StdOut.println();
        }
    }

    private void bfs(Graph G, int v) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            marked[w] = true;
            for (int s : G.adj(w)) {
                if (!marked[s]) {
                    edgeTo[s] = w;
                    //需要及时更新节点的访问情况
                    marked[s] = true;
                    queue.enqueue(s);
                }
            }
        }
    }
}
