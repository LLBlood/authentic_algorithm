package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 918. 环形子数组的最大和
 * @author ll
 * @date 2022-10-13 11:25:58
 **/
public class MaximumSum918 {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int total = 0;
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;
        for (int num : nums) {
            total += num;
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(curMax, maxSum);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        new MaximumSum918().maxSubarraySumCircular(nums);
    }
}
