package com.choco.leetcode;

import edu.princeton.cs.algs4.In;

/**
 * Created by choco on 2018/3/26.
 */
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            int reverse = 0;
            int[] digit = new int[10];
            int size;
            int scale = 1;
            int[] maxs={2,1,4,7,4,8,3,6,4,7};

            Integer.parseInt()
            int before = Math.abs(x);
            if(before<0)
                return 0;
            for(size = 0;before != 0;size++){
                digit[size] = before%10;

                if(Math.abs(x)>=1000000000){
                    if(digit[size]>maxs[size])
                        return 0;
                }

                before /= 10;
            }
            size--;
            while(size>=0){
                reverse += digit[size]*scale;
                scale*=10;
                size--;
            }

            return x<0?(-reverse):reverse;
        }
    }

    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        ReverseInteger.Solution solution = ri.new Solution();
        System.out.println(solution.reverse(-2147483648));
        System.out.println(solution.reverse(-12));
    }
}
