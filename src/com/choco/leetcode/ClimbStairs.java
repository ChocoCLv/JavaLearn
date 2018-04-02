package com.choco.leetcode;

/*
    70. 爬楼梯

    你正在爬楼梯。需要 n 步你才能到达顶部。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？

    注意：给定 n 将是一个正整数。



    示例 1：

    输入： 2
    输出： 2
    说明： 有两种方法可以爬到顶端。

    1.  1 步 + 1 步
    2.  2 步


    示例 2：

    输入： 3
    输出： 3
    说明： 有三种方法可以爬到顶端。

    1.  1 步 + 1 步 + 1 步
    2.  1 步 + 2 步
    3.  2 步 + 1 步
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        Solution solution = cs.new Solution();
        System.out.println(solution.climbStairs(3));
    }

    class Solution {
        private int[] M;

        public int climbStairs(int n) {
            M = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                M[i] = -1;
            }
            M[1] = 1;
            M[0] = 1;
            return OPT(n);
        }

        private int OPT(int n) {
            //System.out.println(n);
            if (M[n] != -1) {
                return M[n];
            }
            M[n] = OPT(n - 1) + OPT(n - 2);
            return M[n];
        }
    }
}
