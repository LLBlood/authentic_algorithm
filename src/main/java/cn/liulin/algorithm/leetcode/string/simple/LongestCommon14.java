package cn.liulin.algorithm.leetcode.string.simple;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 *
 * @author ll
 * @date 2023-10-08 16:51:47
 **/
public class LongestCommon14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder s = new StringBuilder();
        int index = 0;
        while (true) {
            if (strs[0].length() - 1 < index) {
                return s.toString();
            }
            char temp = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (str.length() - 1 < index) {
                    return s.toString();
                }
                if (temp != str.charAt(index)) {
                    return s.toString();
                }
            }
            s.append(temp);
            index++;
        }
    }
}
