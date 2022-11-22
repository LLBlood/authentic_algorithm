package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1572. 矩阵对角线元素的和
 * @author ll
 * @date 2022-11-22 09:44:43
 **/
public class SumOfDiagonal1572 {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = m - 1;
        int sum = 0;
        while (x1 < m) {
            sum += mat[x1][y1];
            sum += mat[x2][y2];
            if (x1 == x2 && y1 == y2) {
                sum -= mat[x1][y1];
            }
            x1++;
            y1++;
            x2++;
            y2--;
        }
        return sum;
    }
}
