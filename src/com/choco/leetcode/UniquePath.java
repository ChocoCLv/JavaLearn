package com.choco.leetcode;

public class UniquePath {

    class Solution {
        int M[][];
        public int uniquePaths(int m, int n) {
            M = new int[m+1][n+1];
            return OPT(m,n);
        }

        private int OPT(int m,int n){
            if(m == 1||n==1){
                return 1;
            }
            if(M[m][n] == 0)
                M[m][n] = OPT(m-1,n)+OPT(m,n-1);
            return M[m][n];
        }
    }

    public static void main(String[] args){
        UniquePath up = new UniquePath();
        Solution solution = up.new Solution();
        System.out.println(solution.uniquePaths(3,3));
    }
}
