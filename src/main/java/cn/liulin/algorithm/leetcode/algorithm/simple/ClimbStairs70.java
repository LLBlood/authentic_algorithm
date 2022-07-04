package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 * 70. 爬楼梯
 * @author ll
 * @date 2022-07-04 09:23:55
 **/
public class ClimbStairs70 {
    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = sum;
            sum = p + q;
        }
        return sum;
    }
}
