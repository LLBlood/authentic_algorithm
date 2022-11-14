package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 343. 整数拆分
 * @author ll
 * @date 2022-10-28 17:18:51
 **/
public class IntegerSplitting343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            if (i != n) {
                max = Math.max(i, max);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new IntegerSplitting343().integerBreak(13);
        System.out.println(i);
    }
}
