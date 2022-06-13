package cn.liulin.algorithm.leetcode.string.simple;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 242. 有效的字母异位词
 * @author ll
 * @date 2022-06-13 16:39:01
 **/
public class ValidLetterHeteronyms242 {
    public boolean isAnagram(String s, String t) {
        int[] sInt = new int[26];
        for (char c : s.toCharArray()) {
            sInt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            sInt[c - 'a']--;
        }
        for (int i : sInt) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }
}
