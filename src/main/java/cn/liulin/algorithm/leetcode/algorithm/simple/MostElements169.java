package cn.liulin.algorithm.leetcode.algorithm.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 * 169. 多数元素
 * @author ll
 * @date 2022-07-06 10:30:58
 **/
public class MostElements169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[n / 2];
    }
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
