package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 931. 下降路径最小和
 * @author ll
 * @date 2022-10-20 13:11:05
 **/
public class MinimumSum931 {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int[] matrixValueRef = new int[n];
        System.arraycopy(matrix[0], 0, matrixValueRef, 0, matrix[0].length);
        for (int i = 1; i < n; i++) {
            int[] matrixValue = new int[n];
            for (int j = 0; j < n; j++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    left = matrixValueRef[j - 1] + matrix[i][j];
                }
                int curr = matrixValueRef[j] + matrix[i][j];
                if (j + 1 < n) {
                    right = matrixValueRef[j + 1] + matrix[i][j];
                }
                matrixValue[j] = Math.min(Math.min(left, curr), right);
            }
            matrixValueRef = matrixValue;
        }
        for (int num : matrixValueRef) {
            min = Math.min(min, num);
        }
        return min;
    }
}
