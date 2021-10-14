package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 598. 范围求和 II
 * 给定一个初始元素全部为0，大小为 m*n 的矩阵M以及在M上的一系列更新操作。
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数a 和 b 的数组表示，含义是将所有符合0 <= i < a 以及 0 <= j < b 的元素M[i][j] 的值都增加 1。
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * @author ll
 * @date 2021-10-14 10:34:37
 **/
public class RangeSummationII598 {
    /**
     * 一遍遍历
     * @author ll
     * @date 2021-10-14 10:57:17
     * @param m
     * @param n
     * @param ops
     * @return int
     **/
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
