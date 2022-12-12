package cn.liulin.algorithm.leetcode.code.medium;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 48. 旋转图像
 * @author ll
 * @date 2022-12-12 18:00:41
 **/
public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
