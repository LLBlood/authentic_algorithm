package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * @author ll
 * @date 2022-11-17 17:29:19
 **/
public class CanTwoStrings1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int j = 0;
        char c = 0;
        char z = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (j == 0) {
                    j++;
                    c = c1;
                    z = c2;
                } else if (j == 1) {
                    if (c1 != z || c2 != c) {
                        return false;
                    }
                    j++;
                } else {
                    return false;
                }
            }
        }
        return j != 1;
    }
}
