package com.choco.offer.Chapter2.Tencent;

import java.util.*;

/**
 * TestCase
 * 3
 * 1 8
 * 2 5
 * 1 2
 */
public class AssignWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNum = scanner.nextInt();
        List<Node> list = new ArrayList<>();
        while (lineNum-- > 0) {
            int times = scanner.nextInt();
            int delayTime = scanner.nextInt();
            list.add(new Node(times, delayTime));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.delayTime - o2.delayTime;
            }
        });
        int left = 0, right = list.size() - 1;
        int maxSum = Integer.MIN_VALUE;
        while (true) {
            if ((left == right && list.get(left).times == 0) || left > right) {
                break;
            }
            maxSum = Math.max(maxSum, list.get(left).delayTime + list.get(right).delayTime);
            list.get(left).times--;
            list.get(right).times--;
            while (left <= right && list.get(left).times == 0) {
                left++;
            }
            while (left <= right && list.get(right).times == 0) {
                right--;
            }
        }
        System.out.println(maxSum);
    }

    static class Node {
        int times;
        int delayTime;

        public Node(int times, int delayTime) {
            this.times = times;
            this.delayTime = delayTime;
        }
    }
}
