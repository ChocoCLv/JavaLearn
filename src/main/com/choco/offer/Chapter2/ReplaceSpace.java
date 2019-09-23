package com.choco.offer.Chapter2;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        int length = str.length() + 2 * spaceNum;
        int loc = length - 1;
        int before = str.length() - 1;
        str.ensureCapacity(length);
        str.setLength(length);

        while (before >= 0) {
            char c = str.charAt(before);
            if (c != ' ') {
                str.setCharAt(loc, c);
                loc--;
            } else {
                str.replace(loc - 2, loc+1, "%20");
                loc -= 3;
            }
            before--;
        }
        return str.toString();
    }
}
