package com.choco.leetcode;

import java.util.*;

public class WordBreak {
    class Solution {
        Map<Character, List<Integer>> charLocs;
        String s;
        List<String> wd;
        int[] dp;

        public boolean wordBreak(String s, List<String> wordDict) {
            charLocs = new HashMap<>();
            this.s = s;
            this.wd = wordDict;
            dp = new int[s.length()];
            this.wd.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length())
                        return -1;
                    else if (o1.length() == o2.length())
                        return 0;
                    else
                        return 1;
                }
            });
            for (int i = 0; i < wd.size(); i++) {
                char c = wd.get(i).charAt(0);
                if (charLocs.containsKey(c)) {
                    charLocs.get(c).add(i);
                } else {
                    List<Integer> locs = new ArrayList<>();
                    locs.add(i);
                    charLocs.put(c, locs);
                }
            }

            return combineWord(0, s.length());
        }

        private boolean combineWord(int start, int end) {
            if (start == end)
                return true;
            if (start > end)
                return false;
            if(dp[start] == -1)
                return false;

            List<Integer> locs = charLocs.getOrDefault(s.charAt(start), new ArrayList<>());
            int leftLength = end - start;
            for (int loc : locs) {
                String word = wd.get(loc);
                boolean isExisted = true;
                for (int i = 0; i < word.length() && i < leftLength; i++) {
                    if (word.charAt(i) != s.charAt(start + i)) {
                        isExisted = false;
                        break;
                    }
                }
                if (isExisted) {
                    boolean flag;
                    flag = combineWord(start + word.length(), end);
                    if (flag)
                        return true;
                }
            }
            dp[start] = -1;
            return false;
        }
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        Solution solution = wb.new Solution();
        List<String> l = Arrays.asList(new String[]{"apple", "pen"});
        System.out.println(solution.wordBreak("applepenapple", l));
    }
}
