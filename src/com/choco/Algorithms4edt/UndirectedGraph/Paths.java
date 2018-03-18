package com.choco.Algorithms4edt.UndirectedGraph;

import com.choco.Algorithms4edt.DataStructure.ResizingArrayStack;
import com.choco.Algorithms4edt.DataStructure.Stack;

public abstract class Paths {
    boolean[] marked;
    int[] edgeTo;
    int s;

    boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Stack<Integer> path = new ResizingArrayStack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);

        path.push(s);
        return path;
    }
}
