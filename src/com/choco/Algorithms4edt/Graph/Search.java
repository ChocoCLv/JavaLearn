package com.choco.Algorithms4edt.Graph;

public abstract class Search {
    boolean[] marked;
    int count;

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
