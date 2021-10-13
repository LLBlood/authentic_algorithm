package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 561. 数组拆分 I
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和
 * @author ll
 * @date 2021-10-13 11:27:11
 **/
public class ArraySplittingI561 {
    /**
     * 自定义法：排序，每次挑第二大的数据
     * @author ll
     * @date 2021-10-13 11:33:58
     * @param nums
     * @return int
     **/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0;i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
