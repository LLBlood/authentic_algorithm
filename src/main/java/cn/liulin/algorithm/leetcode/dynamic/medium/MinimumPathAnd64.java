package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 64. 最小路径和
 * @author ll
 * @date 2022-10-26 11:55:38
 **/
public class MinimumPathAnd64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] newInt = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    newInt[i][j] = grid[i][j];
                } else if (i == 0) {
                    newInt[i][j] = newInt[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    newInt[i][j] = newInt[i - 1][j] + grid[i][j];
                } else {
                    newInt[i][j] = Math.min(newInt[i - 1][j], newInt[i][j - 1]) + grid[i][j];
                }
            }
        }
        return newInt[m - 1][n - 1];
    }
}
