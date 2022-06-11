package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 566. 重塑矩阵
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * @author ll
 * @date 2021-10-13 11:37:12
 **/
public class ReshapingTheMatrix566 {
    /**
     * 自定义：二维数组的一维表示
     * @author ll
     * @date 2021-10-13 13:57:35
     * @param mat
     * @param r
     * @param c
     * @return int[][]
     **/
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int x = mat.length;
        int y = mat[0].length;
        if (c * r == x * y) {
            int n = x * y;
            int[][] newMat = new int[r][c];
            for (int i = 0; i < n; i++) {
                newMat[i / c][i % c] = mat[i / y][i % y];
            }
            return newMat;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        new ReshapingTheMatrix566().matrixReshape(mat, 1 ,4);
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c || (m == r && n == c)) {
            return mat;
        }
        int[][] newMat = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = mat[i][j];
                int sum = i * n + j;
                int x = sum / c;
                int y = sum % c;
                newMat[x][y] = value;
            }
        }
        return newMat;
    }
}
