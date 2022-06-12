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

    public void setZeroes2(int[][] matrix) {
        boolean zeroRow = false;
        boolean zeroCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroCol = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                zeroRow = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zeroCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (zeroRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
