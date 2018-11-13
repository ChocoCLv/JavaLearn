package com.choco.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Q30 与所有单词相关联的字串
 * 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 示例 1:
 * 输入:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出: [0,9]
 * 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2:
 * 输入:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * 输出: []
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords swcoaw = new SubstringWithConcatenationOfAllWords();
        Solution solution = swcoaw.new Solution();
        List<Integer> result = solution.findSubstring("aaaaaaaa", new String[]{"aa", "aa","aa"});
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    class Solution {
        private int[][] a;
        private String[] words;
        private String s;
        private int totalLength = 0;

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            a = new int[s.length()][words.length];
            this.words = words;
            this.s = s;

            for (int i = 0; i < words.length; i++) {
                if (i > 0 && words[i].equals(words[i - 1]))
                    copyA(i - 1, i);
                else
                    searchSubstring(i);
                totalLength += words[i].length();
            }

            for (int i = 0; (i + totalLength) <= s.length(); i++) {
                if (isRight(i, 0, new int[words.length]))
                    result.add(i);
            }

            return result;
        }

        //loc 存储的是当前已经使用的子串索引index+1
        private boolean isRight(int offset, int length, int[] loc) {
            if (length == words.length && length != 0)
                return true;
            if (offset >= s.length())
                return false;

            for (int index : a[offset]) {
                if (index == 0)
                    continue;
                if (searchA(index, loc))
                    continue;
                loc[length] = index;
                if (isRight(offset + words[index - 1].length(), length + 1, loc))
                    return true;
            }
            return false;
        }

        private void copyA(int srcIndex, int dstIndex) {
            for (int i = 0; i < s.length(); i++) {
                if (a[i][srcIndex] != 0) {
                    a[i][dstIndex] = dstIndex + 1;
                }
            }
        }

        private boolean searchA(int a, int[] loc) {
            for (int i : loc) {
                if (i == a)
                    return true;
            }
            return false;
        }

        //搜索words[index]子串在原字符串中出现的位置，位置索引为j，则存入矩阵a的第j列
        private void searchSubstring(int index) {
            int i = 0;
            int j = 0;
            while ((i + words[index].length()) <= s.length()) {
                j = s.indexOf(words[index], i);
                if (j == -1)
                    return;
                insertArray(j, index);
                //i = j + words[index].length();
                i = j + 1;
            }
        }

        private void insertArray(int i, int index) {
            a[i][index] = index + 1;
        }
    }


}
