package cn.liulin.algorithm.leetcode.dynamic.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 139. 单词拆分
 * @author ll
 * @date 2022-10-18 11:45:34
 **/
public class WordSplitting139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
