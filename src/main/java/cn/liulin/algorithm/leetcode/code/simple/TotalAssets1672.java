package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1672. 最富有客户的资产总量
 * @author ll
 * @date 2022-11-21 16:05:52
 **/
public class TotalAssets1672 {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int m = accounts.length;
        int n = accounts[0].length;
        for (int i = 0; i < m; i++) {
            int sum  = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
