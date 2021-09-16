package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @author ll
 * @date 2021-09-16 10:12:38
 **/
public class BestTimeBuyAndSellStocks121 {
    /**
     * 自定义：一次遍历
     * @author ll
     * @date 2021-09-16 10:33:57
     * @param prices
     * @return int
     **/
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price > buy) {
                profit = Math.max(profit, price - buy);
            } else {
                buy = price;
            }
        }
        return profit;
    }
}
