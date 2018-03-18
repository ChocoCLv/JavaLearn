package com.choco.Algorithms4edt.Graph;

public interface Search {

    //顶点v和s是否连通
    boolean marked(int v);


    //与s连通的顶点数
    int count();
}
