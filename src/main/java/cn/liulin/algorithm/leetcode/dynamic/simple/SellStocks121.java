package cn.liulin.algorithm.leetcode.dynamic.simple;

/**
 * cn.liulin.algorithm.leetcode.dynamic.simple$
 * 121. 买卖股票的最佳时机
 * @author ll
 * @date 2022-10-14 15:51:17
 **/
public class SellStocks121 {
    public int maxProfit(int[] prices) {
        int first = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > first) {
                max = Math.max(max, prices[i] - first);
            } else {
                first = prices[i];
            }
        }
        return max;
    }
}
