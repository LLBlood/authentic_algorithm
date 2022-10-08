package cn.liulin.algorithm.leetcode.dynamic.simple;

/**
 * cn.liulin.algorithm.leetcode.dynamic.simple$
 * 509. 斐波那契数
 * @author ll
 * @date 2022-10-08 11:03:02
 **/
public class Fibonacci509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
