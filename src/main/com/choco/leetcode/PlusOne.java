package com.choco.leetcode;


/***
 * 66. 加一
 *
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        Solution solution = po.new Solution();
        int[] n = solution.plusOne(new int[]{9,8});
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            int[] n = new int[digits.length];
            int carry = 1;
            int tmp = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                tmp = digits[i] + carry;
                n[i] = tmp % 10;
                carry = tmp / 10;
            }
            if (carry != 0) {
                int[] ns = new int[n.length + 1];
                ns[0] = carry;
                for (int i = 0; i < n.length; i++) {
                    ns[i + 1] = n[i];
                }
                return ns;
            } else {
                return n;
            }
        }
    }
}
