package cn.liulin.algorithm.leetcode.code.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 976. 三角形的最大周长
 * @author ll
 * @date 2022-11-16 16:32:19
 **/
public class MaximumPerimeter976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int num1 = nums[length - 1];
        int num2 = nums[length - 2];
        int num3 = nums[length - 3];
        if (check(num1, num2, num3)) {
            return num1 + num2 + num3;
        }
        for (int i = length - 4; i >= 0; i--) {
            num1 = num2;
            num2 = num3;
            num3 = nums[i];
            if (check(num1, num2, num3)) {
                return num1 + num2 + num3;
            }
        }
        return 0;
    }

    private boolean check(int num1, int num2, int num3) {
        return num1 + num2 > num3 && num1 + num3 > num2 && num2 + num3 > num1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 3};
        new MaximumPerimeter976().largestPerimeter(nums);
    }

    public int largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
