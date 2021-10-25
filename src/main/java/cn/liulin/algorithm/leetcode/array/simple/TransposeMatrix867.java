package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * @author ll
 * @date 2021-10-25 16:27:06
 **/
public class TransposeMatrix867 {
    /**
     * 自定义：模拟
     * @author ll
     * @date 2021-10-25 16:37:25
     * @param matrix
     * @return int[][]
     **/
    public int[][] transpose(int[][] matrix) {
        int xL = matrix.length;
        int yL = matrix[0].length;
        int[][] matrixB = new int[yL][xL];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixB[j][i] = matrix[i][j];
            }
        }
        return matrixB;
    }
}
