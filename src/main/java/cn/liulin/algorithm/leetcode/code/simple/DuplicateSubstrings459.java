package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 459. 重复的子字符串
 * @author ll
 * @date 2022-12-08 11:32:09
 **/
public class DuplicateSubstrings459 {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length == 1) {
            return false;
        }
        int half = length / 2;
        for (int i = 1; i <= half; i++) {
            if (length % i != 0) {
                continue;
            }
            boolean flag = true;
            String str = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j += i) {
                sb.append(str);
                if (!s.startsWith(sb.toString())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
