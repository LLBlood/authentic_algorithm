package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 392. 判断子序列
 * @author ll
 * @date 2022-10-28 14:23:12
 **/
public class JudgeSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        int sL = s.length();
        int start = 0;
        for (int i = 0; i < sL; i++) {
            char c = s.charAt(i);
            int i1 = t.indexOf(c, start);
            if (i1 < 0) {
                return false;
            } else {
                start = i1 + 1;
            }
        }
        return true;
    }
}
