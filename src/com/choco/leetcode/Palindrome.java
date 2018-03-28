package com.choco.leetcode;

/**
 * Created by choco on 2018/3/28.
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        Solution solution = p.new Solution();
        System.out.println(solution.isPalindrome(21120));
    }

    class Solution {
        int getDigits(int x) {
            return x < 10 ? 1 :
                    x < 100 ? 2 :
                            x < 1000 ? 3 :
                                    x < 10000 ? 4 :
                                            x < 100000 ? 5 :
                                                    x < 1000000 ? 6 : 7;
        }

        public boolean isPalindrome(int x) {
            int a = 0;
            if (x < 10&&x>=0)
                return true;
            if (x < 0 || x%10==0)
                return false;

            while (a < x) {
                a = a * 10 + x % 10;
                x /= 10;
            }

            if(getDigits(x)==getDigits(a)){
                return x == a;
            }else{
                return a/10==x;
            }
        }
    }
}
