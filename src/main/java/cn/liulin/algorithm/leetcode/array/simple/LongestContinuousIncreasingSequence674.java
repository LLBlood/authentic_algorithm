package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * @author ll
 * @date 2021-10-18 10:32:38
 **/
public class LongestContinuousIncreasingSequence674 {
    /**
     * 自定义：贪心算法
     * @author ll
     * @date 2021-10-18 10:38:33
     * @param nums
     * @return int
     **/
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int temp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                temp += 1;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        return Math.max(max, temp);
    }
}
