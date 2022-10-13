package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 53. 最大子数组和
 * @author ll
 * @date 2022-10-13 11:09:20
 **/
public class Maximum53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
