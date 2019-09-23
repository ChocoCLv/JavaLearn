package com.choco.offer.Chapter3;

import org.junit.Test;

public class RecorderArrayTest {

    @Test
    public void recorderOddEven() {
        int[] result = new int[]{1, 2, 3, 4, 5};
        new RecorderArray().recorderOddEven(result);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}