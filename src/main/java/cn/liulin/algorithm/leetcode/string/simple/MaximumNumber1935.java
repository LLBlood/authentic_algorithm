package cn.liulin.algorithm.leetcode.string.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 *
 * @author ll
 * @date 2023-10-09 11:42:11
 **/
public class MaximumNumber1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        char[] chars = brokenLetters.toCharArray();
        String[] s = text.split(" ");
        int size = s.length;
        for (String s1 : s) {
            for (char aChar : chars) {
                if (s1.indexOf(aChar) != -1) {
                    size--;
                    break;
                }
            }
        }
        return size;
    }
}
