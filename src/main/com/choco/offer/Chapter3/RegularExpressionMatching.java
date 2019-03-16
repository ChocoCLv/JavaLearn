package com.choco.offer.Chapter3;

public class RegularExpressionMatching {
    //1 for true;2 for false;
    int[][] M;

    public boolean isMatch(String s, String pattern) {
        if (s == null && pattern == null)
            return true;
        if (s == null || pattern == null)
            return false;
        M = new int[s.length() + 1][pattern.length() + 1];
        return matchCore(s, 0, pattern, 0);
    }

    private boolean matchCore(String s, int sIndex, String pattern, int pIndex) {
        if (sIndex == s.length() && pIndex == pattern.length())
            return true;
        if (pIndex == pattern.length())
            return false;

        if (M[sIndex][pIndex] != 0)
            return M[sIndex][pIndex] == 1;

        if (pIndex < pattern.length() - 1 && pattern.charAt(pIndex + 1) == '*') {
            if (checkEqual(s, sIndex, pattern, pIndex)) {
                M[sIndex][pIndex] = (matchCore(s, sIndex + 1, pattern, pIndex + 2)
                        || matchCore(s, sIndex + 1, pattern, pIndex)
                        || matchCore(s, sIndex, pattern, pIndex + 2)) ? 1 : 2;
            } else {
                M[sIndex][pIndex] = matchCore(s, sIndex, pattern, pIndex + 2) ? 1 : 2;
            }
        } else if (checkEqual(s, sIndex, pattern, pIndex)){
            M[sIndex][pIndex] = matchCore(s, sIndex + 1, pattern, pIndex + 1) ? 1 : 2;
        }
        return M[sIndex][pIndex] == 1;
    }

    private boolean checkEqual(String s, int sIndex, String pattern, int pIndex) {
        return (pIndex < pattern.length() && s.length() > sIndex) &&
                (pattern.charAt(pIndex) == s.charAt(sIndex)
                        || pattern.charAt(pIndex) == '.');
    }
}
