package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 566. 重塑矩阵
 * @author ll
 * @date 2022-11-22 09:56:43
 **/
public class ReshapeMatrix566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] newArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int sum = i * c + j;
                int m1 = sum / n;
                int n1 = sum % n;
                newArr[i][j] = mat[m1][n1];
            }
        }
        return newArr;
    }
}
