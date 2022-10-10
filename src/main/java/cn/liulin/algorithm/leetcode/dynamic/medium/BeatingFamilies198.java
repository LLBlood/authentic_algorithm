package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 198. 打家劫舍
 * @author ll
 * @date 2022-10-10 14:49:41
 **/
public class BeatingFamilies198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(nums[i] + first, second);
            first = second;
            second = max;
        }
        return Math.max(first, second);
    }
}
