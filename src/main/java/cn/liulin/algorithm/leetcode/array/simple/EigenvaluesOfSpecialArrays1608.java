package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * @author ll
 * @date 2022-01-24 10:06:39
 **/
public class EigenvaluesOfSpecialArrays1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0) {
                if (nums[nums.length - 1] < 0) {
                    return 0;
                }
            } else if (i == nums.length) {
                if (nums[0] >= i) {
                    return i;
                }
            } else {
                if (nums[nums.length - 1 - i] < i && nums[nums.length - i] >= i) {
                    return i;
                }
            }
        }
        return -1;
    }
}
