package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 63. 不同路径 II
 * @author ll
 * @date 2022-10-25 16:13:52
 **/
public class DifferentPathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] newInt = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    newInt[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        newInt[i][j] = 1;
                    } else if (i == 0) {
                        newInt[i][j] = newInt[i][j - 1];
                    } else if (j == 0) {
                        newInt[i][j] = newInt[i - 1][j];
                    } else {
                        newInt[i][j] = newInt[i - 1][j] + newInt[i][j - 1];
                    }
                }
            }
        }
        return newInt[m - 1][n - 1];
    }
}
