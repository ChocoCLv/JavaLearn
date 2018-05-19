package com.choco.IEEE;

import java.util.Scanner;

class HappyTrails {
    public static void main(String[] args){
        int pathNum;
        int angle, distance;
        double heightDiff = 0;
        Scanner scanner = new Scanner(System.in);
        pathNum = scanner.nextInt();
        for(int i = 0;i<pathNum;i++){
            angle = scanner.nextInt();
            distance = scanner.nextInt();
            heightDiff += Math.sin(Math.toRadians(angle)) * distance;
        }
        System.out.format("%.2f",heightDiff);
    }
}
