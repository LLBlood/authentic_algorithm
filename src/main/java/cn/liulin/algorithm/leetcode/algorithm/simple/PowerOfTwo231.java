package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 * 231. 2 的幂
 * @author ll
 * @date 2022-07-05 09:47:00
 **/
public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
