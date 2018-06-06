package com.choco.IEEE;

import java.util.Scanner;

class TimeIsOfTheEssence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i;
        String[] units = new String[num];
        int[] besideRate = new int[num - 1];//相邻单位之间的换算
        int[] totalRate = new int[num];//不同单位与最小单位之间的换算
        int[] result = new int[num];
        int target;

        for (i = 0; i < num; i++) {
            units[i] = scanner.next();
            if (i < (num - 1))
                besideRate[i] = scanner.nextInt();
        }

        totalRate[num - 1] = 1;
        for (i = num - 2; i >= 0; i--) {
            totalRate[i] = totalRate[i + 1] * besideRate[i];
        }

        target = scanner.nextInt();

        for (i = 0; i < num; i++) {
            result[i] = target / totalRate[i];
            target %= totalRate[i];
            if (target == 0)
                break;
        }

        while(i>1){
            if(result[i]>=(besideRate[i-1]/2)){
                result[i-1]++;
            }
            i--;
        }

        if (result[1] >= (besideRate[0] / 2)) {
            System.out.println(result[0] + 1 + " " + units[0]);
        } else {
            System.out.println(result[0] + " " + units[0]);
        }

        System.out.print(result[0] + " " + units[0]);

        System.out.println(" " + result[1] + " " + units[1]);

    }
}
