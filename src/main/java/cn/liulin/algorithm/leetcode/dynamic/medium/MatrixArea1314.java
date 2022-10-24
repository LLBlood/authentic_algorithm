package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 1314. 矩阵区域和
 * @author ll
 * @date 2022-10-21 17:08:54
 **/
public class MatrixArea1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int i1 = Math.max(i - k, 1);
                int i2 = Math.min(i + k, m);
                int j1 = Math.max(j - k, 1);
                int j2 = Math.min(j + k, n);
                mat[i - 1][j - 1] = dp[i2][j2] - dp[i1 - 1][j2] - dp[i2][j1 - 1] + dp[i1 - 1][j1 - 1];
            }
        }
        return mat;
    }
}
