package cn.liulin.algorithm.leetcode.string.simple;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 *
 * @author ll
 * @date 2023-10-08 16:36:37
 **/
public class InvertVowels345 {
    public String reverseVowels(String s) {
        char[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> characterList = new HashSet<>();
        for (char a : arr) {
            characterList.add(a);
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (!characterList.contains(chars[start])) {
                start++;
            } else if (!characterList.contains(chars[end])) {
                end--;
            } else {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(chars);
    }
}
