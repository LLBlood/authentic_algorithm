package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 62. 不同路径
 * @author ll
 * @date 2022-10-25 15:33:24
 **/
public class DifferentPaths62 {
    public int uniquePaths(int m, int n) {
        int[][] newInt = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    newInt[i][j] = 1;
                } else {
                    newInt[i][j] = newInt[i - 1][j] + newInt[i][j - 1];
                }
            }
        }
        return newInt[m - 1][n - 1];
    }
}
