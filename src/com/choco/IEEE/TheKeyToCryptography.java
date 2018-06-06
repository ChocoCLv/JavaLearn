package com.choco.IEEE;

import java.util.Scanner;

public class TheKeyToCryptography {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.next();
        String key = scanner.next();
        StringBuilder result = new StringBuilder();
        if(msg.length() <= key.length()){
            for(int i=0;i<msg.length();i++)
            {
                int x=msg.charAt(i) - key.charAt(i);
                if(x<0)
                    result.append((char)(x+26+'A'));
                else
                    result.append((char)(x+'A'));
            }
        }else{
            for(int i=0;i<key.length();i++)
            {
                int x=msg.charAt(i) - key.charAt(i);
                if(x<0)
                    result.append((char)(x+26+'A'));

                else
                    result.append((char)(x+'A'));
            }
            int j=0;
            for(int i=key.length();i<msg.length();i++)
            {
                int x=msg.charAt(i)-result.charAt(j);
                if(x<0)
                    result.append((char)(x+26+'A'));
                else
                    result.append((char)(x+'A'));
                j++;
            }
        }

        System.out.println(result.toString());
    }
}
