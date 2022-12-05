package cn.liulin.algorithm.leetcode.code.medium;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 28. 找出字符串中第一个匹配项的下标
 * @author ll
 * @date 2022-12-05 14:00:21
 **/
public class FirstMatch28 {
    public int strStr(String haystack, String needle) {
        int hL = haystack.length();
        int nL = needle.length();
        if (hL < nL) {
            return -1;
        }
        for (int i = 0; i <= hL - nL; i++) {
            boolean check = true;
            for (int j = i; j < i + nL; j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return i;
            }
        }
        return -1;
    }
}
