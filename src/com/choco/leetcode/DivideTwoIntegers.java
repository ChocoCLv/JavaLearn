package com.choco.leetcode;

/***
 * Q29 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers dti = new DivideTwoIntegers();
        Solution solution = dti.new Solution();
        int dividend = Integer.MIN_VALUE;
        int divisor = 1;
        System.out.println(solution.divide(dividend, divisor));
        System.out.println(dividend / divisor);
    }

    class Solution {
        int n = 1;
        int left;
        private int[] a = new int[32];
        private int[] b = new int[32];

        public int divide(int dividend, int divisor) {
            if (dividend == -2147483648) {
                if (divisor == -1)
                    return 2147483647;
                else if (divisor == -2147483648)
                    return 1;
            }
            if (divisor == -2147483648)
                return 0;
            boolean isNegative = false;
            int result = 0;
            if (divisor < 0) {
                isNegative = !isNegative;
                divisor = 0 - divisor;
            }
            if (dividend < 0) {
                isNegative = !isNegative;
                if (dividend == -2147483648) {
                    dividend += divisor;
                    result += 1;
                }
                dividend = 0 - dividend;
            }

            left = dividend;

            fillA(dividend, divisor);
            while (left >= divisor) {
                result += searchA();
            }
            if (isNegative)
                return 0 - result;
            else
                return result;
        }

        private void fillA(int dividend, int divisor) {
            a[0] = divisor;
            b[0] = 1;
            for (; (dividend - a[n - 1]) >= a[n - 1]; n++) {
                a[n] = a[n - 1] + a[n - 1];
                b[n] = b[n - 1] + b[n - 1];
            }
        }

        private int searchA() {
            int index = 0;
            while (a[index] <= left && index < n) {
                index++;
            }
            left -= a[index - 1];
            return b[index - 1];
        }
    }
}
