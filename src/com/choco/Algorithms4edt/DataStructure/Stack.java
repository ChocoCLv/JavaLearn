package com.choco.Algorithms4edt.DataStructure;

public interface Stack<Item> extends Iterable<Item> {
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
