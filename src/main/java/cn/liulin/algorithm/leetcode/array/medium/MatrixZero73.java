package cn.liulin.algorithm.leetcode.array.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 73. 矩阵置零
 * @author ll
 * @date 2022-06-12 20:14:23
 **/
public class MatrixZero73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (xSet.contains(i) || ySet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
