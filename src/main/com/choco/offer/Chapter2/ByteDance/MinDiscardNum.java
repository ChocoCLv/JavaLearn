package com.choco.offer.Chapter2.ByteDance;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinDiscardNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = scanner.nextInt();
        while (testCaseNum-- > 0) {
            int num = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[num];
            int[] result = new int[num];
            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
            }
        }
    }

    /***
     * 做完第n题时间不超过m秒，至少需要跳过几道题，
     * @param n
     * @return
     */
    private static int[] minDiscardNum(int n, int m, int[] times) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int time = 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int discardNum = 0;
            time += times[i];
                while (time > m) {

            }
            result[i] = discardNum;
            queue.add(times[i]);
        }
        return result;
    }
}
