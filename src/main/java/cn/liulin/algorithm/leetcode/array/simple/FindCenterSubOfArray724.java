package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 724. 寻找数组的中心下标
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * @author ll
 * @date 2021-10-19 09:53:13
 **/
public class FindCenterSubOfArray724 {
    /**
     * 自定义，双向匹配法
     * @author ll
     * @date 2021-10-19 10:13:35
     * @param nums
     * @return int
     **/
    public int pivotIndex(int[] nums) {
        int subIndex = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                subIndex = i;
                break;
            }
        }
        return subIndex;
    }

    /**
     * 官方：前缀和
     * @author ll
     * @date 2021-10-19 10:13:29
     * @param nums
     * @return int
     **/
    public int pivotIndex2(int[] nums) {
        int sum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
