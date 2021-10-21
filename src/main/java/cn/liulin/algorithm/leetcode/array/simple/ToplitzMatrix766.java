package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * @author ll
 * @date 2021-10-21 11:36:06
 **/
public class ToplitzMatrix766 {
    /**
     * 自定义：遍历
     * @author ll
     * @date 2021-10-21 11:40:28
     * @param matrix
     * @return boolean
     **/
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 1 < matrix.length && j + 1 < matrix[i].length) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
