package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 * 136. 只出现一次的数字
 * @author ll
 * @date 2022-07-06 10:13:02
 **/
public class NumbersOnlyOnce136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        int start = 0;
        for (int num : nums) {
            start ^= num;
        }
        return start;
    }
}
