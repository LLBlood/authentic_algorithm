package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 122. 买卖股票的最佳时机 II
 * @author ll
 * @date 2022-10-14 16:01:22
 **/
public class SellStocksII122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int left = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > left) {
                sum += prices[i] - left;
            }
            left = prices[i];
        }
        return sum;
    }
}
