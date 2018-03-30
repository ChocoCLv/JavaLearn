package com.choco.leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        Solution solution = lp.new Solution();
        System.out.println(solution.longestPalindrome("abba"));
    }

    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            String odd = "";
            String even = "";

            for (int i = 0; i < s.length(); i++) {
                if ((i + 1) < s.length() && s.charAt(i) == s.charAt(i + 1))
                    even = searchPalindrome(s, i, i + 1);

                odd = searchPalindrome(s, i, i);
                res = res.length() >= even.length() && res.length() >= odd.length() ? res :
                        even.length() >= odd.length() ? even : odd;
            }
            return res;
        }

        private String searchPalindrome(String s, int left, int right) {

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;
            }

            return s.substring(left + 1, right);
        }
    }
}
