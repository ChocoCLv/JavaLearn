package com.choco.Algorithms4edt.Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstSearch extends Search {
    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }
        StdOut.println();

        if (search.count() != G.V())
            StdOut.print("NOT ");
        StdOut.println("connected");
    }

    private void bfs(Graph G, int v) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        while(!queue.isEmpty()){
            int s = queue.dequeue();
            marked[s] = true;
            count++;
            for(int w:G.adj(s)){
                if(!marked[w]){
                    marked[w]=true;
                    count++;
                }
            }
        }
    }
}
