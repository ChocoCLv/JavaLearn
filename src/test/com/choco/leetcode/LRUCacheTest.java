package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

    @Test
    public void testPut1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(cache.get(1), 1);// 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        assertEquals(cache.get(2), -1);    // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        assertEquals(cache.get(1), -1);       // 返回 -1 (未找到)
        assertEquals(cache.get(3), 3);     // 返回  3
        assertEquals(cache.get(4), 4);      // 返回  4
        cache.put(3,5);
        assertEquals(cache.get(3), 5);      // 返回  4
    }

    @Test
    public void testPut2(){
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        assertEquals(cache.get(2), 1);// 返回  1
    }

    @Test
    public void testPut3(){
        LRUCache cache = new LRUCache(2);
        assertEquals(cache.get(2), -1);    // 返回 -1 (未找到)
        cache.put(2,6);
        assertEquals(cache.get(1), -1);       // 返回 -1 (未找到)
        cache.put(1,5);
        cache.put(1,2);
        assertEquals(cache.get(1), 2);       // 返回 -1 (未找到)
        assertEquals(cache.get(2), 6);    // 返回 -1 (未找到)
    }
}