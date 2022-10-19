package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 96. 不同的二叉搜索树
 * @author ll
 * @date 2022-10-19 16:04:32
 **/
public class DifferentBinary96 {
    public int numTrees(int n) {
        int[] gp = new int[n + 1];
        gp[0] = 1;
        gp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                gp[i] += gp[j - 1] * gp[i - j];
            }
        }
        return gp[n];
    }
}
