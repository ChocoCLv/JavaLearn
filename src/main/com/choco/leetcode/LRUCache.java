package com.choco.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Q  LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
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
    private Map<Integer,Element> cache;
    private int lruKey;

    private PriorityQueue lruQueue;
    private int capacity;
    class Element{
        int key;
        int value;
        int times;

        public Element(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity=capacity;
        lruQueue = new PriorityQueue(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.times-o1.times;
            }
        });
    }

    public int get(int key) {
        if(cache.containsKey(key))
            return cache.get(key).value;
        return -1;
    }

    //堆排序
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Element ele = cache.get(key);
            ele.times++;
            ele.value=value;
            ele.key = key;
        }else{
            if(cache.size()==capacity){
                Element ele = (Element)lruQueue.poll();
                cache.remove(ele.key);
            }
            cache.put(key,new Element(key,value,0));
        }
    }
}
