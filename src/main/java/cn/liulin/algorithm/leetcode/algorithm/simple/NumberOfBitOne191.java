package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 * 191. 位1的个数
 * @author ll
 * @date 2022-07-05 09:51:52
 **/
public class NumberOfBitOne191 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
