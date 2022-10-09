package cn.liulin.algorithm.leetcode.dynamic.simple;

/**
 * cn.liulin.algorithm.leetcode.dynamic.simple$
 * 746. 使用最小花费爬楼梯
 * @author ll
 * @date 2022-10-09 09:54:09
 **/
public class MinCostClimb746 {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0, curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
