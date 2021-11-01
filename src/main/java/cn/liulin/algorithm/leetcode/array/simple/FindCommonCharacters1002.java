package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1002. 查找共用字符
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 * @author ll
 * @date 2021-11-01 10:14:43
 **/
public class FindCommonCharacters1002 {
    /**
     * 自定义：暴力法
     * @author ll
     * @date 2021-11-01 11:08:00
     * @param words
     * @return java.util.List<java.lang.String>
     **/
    public List<String> commonChars(String[] words) {
        List<String> str = new LinkedList<>();
        for (char c : words[0].toCharArray()) {
            str.add(String.valueOf(c));
        }
        if (str.isEmpty()) {
            return str;
        }
        for (int i = 1; i < words.length; i++) {
            List<String> temp = new LinkedList<>();
            for (char c : words[i].toCharArray()) {
                if (str.contains(String.valueOf(c))) {
                    temp.add(String.valueOf(c));
                    str.remove(String.valueOf(c));
                }
            }
            str = temp;
            if (str.isEmpty()) {
                return str;
            }
        }
        return str;
    }

    /**
     * 官方：计数法
     * @author ll
     * @date 2021-11-01 11:08:21
     * @param words
     * @return java.util.List<java.lang.String>
     **/
    public List<String> commonChars2(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //找出字符c在26个数组位的个数+1
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                //找出每个字符最小的个数
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                //找到i对应字符c的个数并加入到list中
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
