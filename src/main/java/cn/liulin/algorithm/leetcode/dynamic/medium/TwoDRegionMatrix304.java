package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 304.二维区域和检索 - 矩阵不可变
 * @author ll
 * @date 2022-10-24 16:19:35
 **/
public class TwoDRegionMatrix304 {
    int[][] dp = null;

    public TwoDRegionMatrix304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
