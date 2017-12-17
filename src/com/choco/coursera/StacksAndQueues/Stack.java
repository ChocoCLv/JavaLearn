package com.choco.coursera.StacksAndQueues;

public class Stack<Item> {
    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    private class Node {
        Item item;
        Node next;
    }
}
