package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * @author ll
 * @date 2021-09-24 10:24:19
 **/
public class ThirdNum414 {

    /**
     * 自定义：先排序再找数字
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int thirdCount = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                thirdCount++;
                if (thirdCount == 2) {
                    return nums[i - 1];
                }
            }
        }
        return max;
    }

    /**
     * 三指针法
     * @author ll
     * @date 2021-09-24 10:35:13
     * @param nums
     * @return int
     **/
    public int thirdMax2(int[] nums) {
        long first, second, third;
        first = second = third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first || nums[i] == second || nums[i] == third) {
                continue;
            }
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}
