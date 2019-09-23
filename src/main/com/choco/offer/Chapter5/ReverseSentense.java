package com.choco.offer.Chapter5;

public class ReverseSentense {
    public String ReverseSentence(String str) {
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
