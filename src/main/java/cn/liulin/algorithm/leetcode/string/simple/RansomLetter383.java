package cn.liulin.algorithm.leetcode.string.simple;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 383. 赎金信
 * @author ll
 * @date 2022-06-13 16:32:34
 **/
public class RansomLetter383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        char[] intChars = new char[128];
        for (char aChar : chars) {
            intChars[aChar]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (intChars[c] == 0) {
                return false;
            }
            intChars[c]--;
        }
        return true;
    }
}
