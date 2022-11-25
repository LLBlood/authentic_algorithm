package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 242. 有效的字母异位词
 * @author ll
 * @date 2022-11-25 13:39:33
 **/
public class ValidAlphabetic242 {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a']--;
        }
        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

}
