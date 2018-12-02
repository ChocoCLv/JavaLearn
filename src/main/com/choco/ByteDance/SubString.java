package com.choco.ByteDance;

import java.util.*;

public class SubString {

    private int result;

    public static void main(String[] args) {
        SubString ss = new SubString();
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            result.add(ss.getMaxNotIsomorphicNum(scanner.next()));
        }
        for (int r : result) {
            System.out.println(r);
        }
    }

    public int getMaxNotIsomorphicNum(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        Map<Integer, Set<SuperString>> substrings;
        result = 2;//长度为1和长度为n的子串

        substrings = generateSubstring(s);

        substringClassify(s, substrings);

        return result;
    }

    public boolean isIsomorphic(String s1, String s2) {
        return isDirectedInjection(s1, s2) && isDirectedInjection(s2, s1);
    }

    public boolean isDirectedInjection(String src, String dst) {
        Set<Character> tested = new HashSet<>();
        for (int i = 0; i < src.length(); i++) {
            int index = i;
            char c = src.charAt(i);
            if (tested.contains(c))
                continue;
            tested.add(c);
            Set<Character> cs = new HashSet<>();
            while ((index = src.indexOf(c, index)) != -1) {
                cs.add(dst.charAt(index));
                if (cs.size() != 1)
                    return false;
                index++;
                if (index >= src.length())
                    break;
            }
        }
        return true;
    }

    //生成不同长度的子串，长度范围[2,n-1]，n为s长度
    public Map<Integer, Set<SuperString>> generateSubstring(String s) {
        Map<Integer, Set<SuperString>> substrings = new HashMap<>();
        byte[] bs = s.getBytes();
        for (int i = 2; i < s.length(); i++) {
            generateSubstringByLength(bs, i, substrings);
        }
        return substrings;
    }

    private void generateSubstringByLength(byte[] bs, int length, Map<Integer, Set<SuperString>> substrings) {
        Set<SuperString> ss = new HashSet<>();
        for (int i = 0; i < bs.length - length + 1; i++) {
            String tmp = new String(bs, i, length);
            SuperString tmpss = new SuperString();
            tmpss.s = tmp;
            tmpss.father = tmp;//相同的字符串是同构的
            ss.add(tmpss);
        }
        substrings.put(length, ss);
    }

    public int substringClassify(String s, Map<Integer, Set<SuperString>> substrings) {
        for (int i = 2; i < s.length(); i++) {
            substringClassifyByLength(i, substrings);
        }
        return result;
    }

    public int substringClassifyByLength(int length, Map<Integer, Set<SuperString>> substrings) {
        Set<String> fathers = new HashSet<>();
        Set<SuperString> ss = substrings.get(length);
        List<SuperString> ssList = new ArrayList<>(ss);
        for (int i = 0; i < ss.size(); i++) {
            SuperString superS1 = ssList.get(i);
            fathers.add(superS1.father);
            for (int j = i + 1; j < ss.size(); j++) {
                SuperString superS2 = ssList.get(j);
                if (isIsomorphic(superS1.s, superS2.s)) {
                    superS2.father = superS1.father;
                } else {
                    fathers.add(superS2.father);
                }
            }
        }
        result += fathers.size();
        return result;
    }

    class SuperString {
        String s;
        String father;//同构源
    }
}
