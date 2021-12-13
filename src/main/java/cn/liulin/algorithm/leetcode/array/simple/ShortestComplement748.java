package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 748. 最短补全词
 * @author ll
 * @date 2021-12-13 15:30:04
 **/
public class ShortestComplement748 {
    /**
     * 暴力法
     * @author ll
     * @date 2021-12-13 15:43:15
     * @param licensePlate
     * @param words
     * @return java.lang.String
     **/
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<Character> list = new ArrayList<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                list.add(c);
            }
        }
        for (String word : words) {
            String temp = word;
            boolean flag = true;
            for (Character character : list) {
                if (!temp.contains(String.valueOf(character))) {
                    flag = false;
                    break;
                } else {
                    temp = temp.replaceFirst(String.valueOf(character), "");
                }
            }
            if (flag) {
                return word;
            }
        }
        return null;
    }

    /**
     * 计数法
     * @author ll
     * @date 2021-12-13 15:43:15
     * @param licensePlate
     * @param words
     * @return java.lang.String
     **/
    public String shortestCompletingWord2(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                ++cnt[Character.toLowerCase(ch) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; ++i) {
            int[] c = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};
        new ShortestComplement748().shortestCompletingWord(licensePlate, words);
    }
}
