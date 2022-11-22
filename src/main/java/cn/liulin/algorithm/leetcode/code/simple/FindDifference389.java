package cn.liulin.algorithm.leetcode.code.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 389. 找不同
 * @author ll
 * @date 2022-11-22 17:53:19
 **/
public class FindDifference389 {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return c;
            }
            arr[c - 'a']--;
        }
        return 0;
    }

    public char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }


    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
