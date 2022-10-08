package cn.liulin.algorithm.leetcode.dynamic.simple;

/**
 * cn.liulin.algorithm.leetcode.dynamic.simple$
 * 1137. 第 N 个泰波那契数
 * @author ll
 * @date 2022-10-08 11:13:53
 **/
public class Tabonacci1137 {
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1, r = 2;
        if (n == 0) {
            return t0;
        } else if (n < 3) {
            return t1;
        }
        for (int i = 3; i <= n; i++) {
            r = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = r;
        }
        return r;
    }
}
