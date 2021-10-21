package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 747. 至少是其他数字两倍的最大数
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * @author ll
 * @date 2021-10-21 11:28:13
 **/
public class MaxNumberTwiceTwoFigure747 {
    /**
     * 自定义：线性扫描
     * @author ll
     * @date 2021-10-21 11:34:38
     * @param nums
     * @return int
     **/
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                int i1 = nums[i] * 2;
                if (max < i1) {
                    return -1;
                }
            }
        }
        return index;
    }
}
