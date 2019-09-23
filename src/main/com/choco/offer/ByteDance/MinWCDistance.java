package com.choco.offer.ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinWCDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String shopOrWC = scanner.next();
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        List<Integer> wcIndex = new ArrayList<>();
        wcIndex.add(-num - 1);
        for (int i = 0; i < shopOrWC.length(); i++) {
            if (shopOrWC.charAt(i) == 'O') {
                wcIndex.add(i);
            }
        }
        wcIndex.add(2 * num + 1);
        int currentWC = 0;
        for (int i = 0; i < num; i++) {
            int leftDis = i - wcIndex.get(currentWC);
            int rightDis = wcIndex.get(currentWC + 1) - i;
            result[i] = Math.min(leftDis, rightDis);
            if (i == wcIndex.get(currentWC + 1)) {
                currentWC++;
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
