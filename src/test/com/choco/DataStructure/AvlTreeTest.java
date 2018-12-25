package com.choco.DataStructure;

import org.junit.Test;

/**
 * Created by choco on 2018/12/25.
 */
public class AvlTreeTest {
    @Test
    public void testInsert() {
        AvlTree<Integer> t = new AvlTree<>();
        for (int i = 0; i < 20; i++) {
            t.insert(i);
        }

        t.printTreeInfoByInOrder();
    }
}