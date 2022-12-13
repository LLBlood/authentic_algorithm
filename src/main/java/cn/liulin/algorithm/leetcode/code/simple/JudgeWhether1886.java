package cn.liulin.algorithm.leetcode.code.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1886. 判断矩阵经轮转后是否一致
 * @author ll
 * @date 2022-12-12 18:18:23
 **/
public class JudgeWhether1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        // 最多旋转 4 次
        for (int k = 0; k < 4; ++k) {
            // 旋转操作
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < (n + 1) / 2; ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n-1-j][i];
                    mat[n-1-j][i] = mat[n-1-i][n-1-j];
                    mat[n-1-i][n-1-j] = mat[j][n-1-i];
                    mat[j][n-1-i] = temp;
                }
            }
            if (checkIsSame(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIsSame(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
