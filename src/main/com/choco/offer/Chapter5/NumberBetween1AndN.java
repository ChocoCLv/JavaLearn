package com.choco.offer.Chapter5;

public class NumberBetween1AndN {
    public  static int NumberOf1Between1AndN_Solution(int n) {
        if(n<1)
            return 0;
        if(n<10)
            return 1;
        String str = String.valueOf(n);
        int length = str.length();
        int first = str.charAt(0) - '0';

        int numOfFirstDigits = 0;
        if((first) > 1)
            numOfFirstDigits = (int)Math.pow(10,length-1);
        else
            numOfFirstDigits = Integer.valueOf(str.substring(1)) + 1;

        int numOtherDigits = first * (length -1) * (int)Math.pow(10,length-2);

        int numRecursive = NumberOf1Between1AndN_Solution(Integer.valueOf(str.substring(1)));

        return numOfFirstDigits+ numOtherDigits+ numRecursive;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(55));
    }
}
