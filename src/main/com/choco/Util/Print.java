package com.choco.Util;

public class Print {
    public static void PrintIntArray(int[] n){
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
    }


    public static void println(String msg){
        System.out.println(msg);
    }

    public static void println(){
        System.out.println();
    }

    public static void print(String msg){
        System.out.print(msg);
    }
}
