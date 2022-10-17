package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 309. 最佳买卖股票时机含冷冻期
 * 分三种情况
 * 一、持有股票，收益为f[i]0
 * 二、不持有股票，且在冷冻期f[i]1
 * 三、不持有股票，且不在冷冻期f[i]2
 * @author ll
 * @date 2022-10-17 09:36:27
 **/
public class BestTimeSellStock309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int f0 = - prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newF0 = Math.max(f0, f2 - prices[i]);
            int newF1 = f0 + prices[i];
            int newF2 = Math.max(f2, f1);
            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }
        return Math.max(f1, f2);
    }
}
