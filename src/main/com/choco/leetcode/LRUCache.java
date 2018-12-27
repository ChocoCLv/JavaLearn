package com.choco.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Q146 LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 缓存容量  );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class LRUCache {
    LRUNode head;
    LRUNode tail;
    private int capacity;
    private int size;
    private Map<Integer, LRUNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        LRUNode node = map.getOrDefault(key,null);
        if(node == null)
            return -1;
        head = moveNodeToHead(node);
        return node.value;
    }

    private LRUNode moveNodeToHead(LRUNode node) {
        if(node == head)
            return node;
        //将被访问的节点移动到head
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            //说明当前节点为尾节点
            tail = tail.pre;
        }
        node.next = head;
        head.pre = node;
        head = node;
        return head;
    }

    public void put(int key, int value) {
        //为空
        if (head == null) {
            head = new LRUNode(key, value);
            tail = head;
            map.put(key,head);
            size++;
            return;
        }
        //key已存在
        if(map.containsKey(key)){
            //将被访问的节点移动到head
            LRUNode node = map.get(key);
            node.value = value;
            head = moveNodeToHead(node);
            return;
        }

        //插入新key
        //在头部插入节点
        head.pre = new LRUNode(key, value);
        head.pre.next = head;
        head = head.pre;
        size++;
        map.put(key,head);
        if (size > capacity) {
            //删除尾节点
            map.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
            size--;
        }

    }

    class LRUNode {
        LRUNode pre;
        LRUNode next;
        int key;
        int value;

        LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
