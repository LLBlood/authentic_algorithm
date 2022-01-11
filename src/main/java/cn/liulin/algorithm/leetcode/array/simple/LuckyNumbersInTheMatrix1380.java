package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1380. 矩阵中的幸运数
 * @author ll
 * @date 2022-01-11 16:04:47
 **/
public class LuckyNumbersInTheMatrix1380 {
    /**
     * 暴力法
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] tempM = matrix[i];
            int max = tempM[0];
            int index = 0;
            for (int j = 1; j < n; j++) {
                if (max > tempM[j]) {
                    max = tempM[j];
                    index = j;
                }
            }
            boolean flag = true;
            for (int z = 0; z < m; z++) {
                if (max < matrix[z][index]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(max);
            }
        }
        return list;
    }

    /**
     * 存入行的最小值和列的最大值
     * @author ll
     * @date 2022-01-11 16:29:59
     * @param matrix
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> luckyNumbers2(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rMin = new int[m];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        int[] cMax = new int[n];
        Arrays.fill(cMax, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rMin[i] = Math.min(rMin[i], matrix[i][j]);
                cMax[j] = Math.max(cMax[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == rMin[i] && matrix[i][j] == cMax[j]) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }
}
