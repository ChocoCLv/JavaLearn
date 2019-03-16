package com.choco.offer.Chapter5;

import java.util.ArrayList;

public class KLeastNumbers {
    //最大堆
    class BinaryHeap {
        int[] heap;
        int limit;
        int currentSize;

        void insert(int x) {
            if (currentSize == limit)
                removeMax();
            int loc = ++currentSize;
            heap[0] = x;
            while (x > heap[loc / 2]) {
                heap[loc] = heap[loc / 2];
                loc /= 2;
            }
            heap[loc] = x;
        }

        int getMax() {
            return heap[1];
        }

        int removeMax() {
            int result = heap[1];
            heap[1] = heap[currentSize];

            int loc = 1;
            int child = 0;
            for (; 2 * loc < currentSize; loc = child) {
                child = 2 * loc;
                if (child != currentSize && heap[child + 1] > heap[child])
                    child++;
                if (heap[loc] < heap[child])
                    heap[loc] = heap[child];
                else
                    break;
            }
            heap[loc] = heap[currentSize];
            currentSize--;
            return result;
        }

        BinaryHeap(int k) {
            heap = new int[k + 1];
            limit = k;
            currentSize = 0;
        }
    }

    public ArrayList<Integer> getKLeastNumbers(int[] nums, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if(nums.length < k || k == 0)
            return results;
        BinaryHeap heap = new BinaryHeap(k);
        for (int n : nums) {
            if(heap.currentSize<k || heap.getMax()>n)
                heap.insert(n);
        }
        for(int i=1;i<=k;i++){
            results.add(heap.heap[i]);
        }
        return results;
    }
}
