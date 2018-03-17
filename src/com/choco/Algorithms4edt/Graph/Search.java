package com.choco.Algorithms4edt.Graph;

public abstract class Search {
    Graph G;
    int s;
    Search(Graph G, int s){
        this.G = G;
        this.s = s;
    }

    //顶点v和s是否连通
    abstract boolean marked(int v);


    //与s连通的顶点数
    abstract int count();
}
