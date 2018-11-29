package com.choco.leetcode;

public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zc = new ZigZagConversion();
        Solution solution = zc.new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

    class Solution {
        public String convert(String s, int numRows) {
            StringBuilder sb = new StringBuilder("");
            if (numRows == 1) {
                return s;
            }
            for (int i = 1; i <= numRows; i++) {
                if (i == 1 || i == numRows) {
                    for (int j = 1; ((j - 1) * (2 * numRows - 2) + (i - 1)) < s.length(); j++) {
                        sb.append(s.charAt((j - 1) * (2 * numRows - 2) + (i - 1)));
                    }
                } else {
                    int j = 1;
                    int seq, column;
                    seq = 0;
                    while (true) {
                        column = (j + 1) / 2;
                        if (j % 2 == 0) {
                            seq += 2 * (numRows - i);
                        } else {
                            seq = (column - 1) * (2 * numRows - 2) + (i - 1);
                        }
                        if (seq >= s.length())
                            break;
                        sb.append(s.charAt(seq));
                        j++;
                    }
                }
            }
            return sb.toString();
        }
    }
}
