package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10^-5 的答案都将被视为正确答案。
 * @author ll
 * @date 2021-10-15 13:40:27
 **/
public class MaxAverageNumberOfSubArraysI643 {
    /**
     * 自定义：暴力法超时
     * @author ll
     * @date 2021-10-15 13:54:08
     * @param nums
     * @param k
     * @return double
     **/
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp = 0;
            for (int j = i; j < k + i; j++) {
                temp += nums[j];
            }
            max = Math.max(max, temp);
        }
        return (max * 1.0) / k;
    }

    /**
     * 官方法：滑动窗口
     * @author ll
     * @date 2021-10-15 14:02:47
     * @param nums
     * @param k
     * @return double
     **/
    public double findMaxAverage2(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += nums[i];
        }
        max = Math.max(max, temp);
        for (int i = k; i < nums.length; i++) {
            temp = temp - nums[i - k] + nums[i];
            max = Math.max(max, temp);
        }
        return (max * 1.0) / k;
    }
}
