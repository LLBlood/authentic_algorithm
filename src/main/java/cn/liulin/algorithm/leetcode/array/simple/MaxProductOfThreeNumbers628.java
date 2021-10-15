package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * @author ll
 * @date 2021-10-15 11:46:58
 **/
public class MaxProductOfThreeNumbers628 {
    /**
     * 排序算法
     * @author ll
     * @date 2021-10-15 13:22:42
     * @param nums
     * @return int
     **/
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length-1] * nums[length-2] * nums[length-3], nums[length-1]*nums[0]*nums[1]);
    }

    /**
     * 线性扫描
     * @author ll
     * @date 2021-10-15 13:23:03
     * @param nums
     * @return int
     **/
    public int maximumProduct2(int[] nums) {
        //第一小
        int min1 = Integer.MAX_VALUE;
        //第二小
        int min2 = Integer.MAX_VALUE;
        //第一大
        int max1 = Integer.MIN_VALUE;
        //第二大
        int max2 = Integer.MIN_VALUE;
        //第三大
        int max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
