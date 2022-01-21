package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1572. 矩阵对角线元素的和
 * @author ll
 * @date 2022-01-21 10:06:31
 **/
public class SumOfDiagonalElementsOfMatrix1572 {
    public int diagonalSum(int[][] mat) {
        int x = mat.length;
        int mid = x / 2;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += mat[i][i] + mat[i][x - i - 1];
        }
        return sum - mat[mid][mid] * (x & 1);
    }
}
