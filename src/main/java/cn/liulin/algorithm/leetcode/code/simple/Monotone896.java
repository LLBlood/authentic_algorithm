package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 896. 单调数列
 * @author ll
 * @date 2022-12-05 13:49:13
 **/
public class Monotone896 {
    public boolean isMonotonic(int[] nums) {
        int trend = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (trend == 0) {
                trend = nums[i + 1] - nums[i];
            } else if ((nums[i + 1] > nums[i] && trend < 0) || (nums[i + 1] < nums[i] && trend > 0)) {
                return false;
            }
        }
        return true;
    }
}
