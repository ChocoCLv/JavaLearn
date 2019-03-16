package com.choco.offer.Chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符的所有组合
 */
public class CharsCombination {


    public void combinations(char[] cs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= cs.length; i++) {
            combination(cs, 0, i, stringBuilder);
        }
    }

    private void combination(char[] cs, int begin, int len, StringBuilder sb) {
        if (len == 0) {
            System.out.println(sb.toString());
            return;
        }

        if (begin == cs.length)
            return;

        sb.append(cs[begin]);
        combination(cs, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        combination(cs, begin + 1, len, sb);
    }
}
