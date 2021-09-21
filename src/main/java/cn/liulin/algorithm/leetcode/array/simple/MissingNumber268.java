package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @author ll
 * @date 2021-09-14 10:19:14
 **/
public class MissingNumber268 {
    /**
     * 自定义：哈希法
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 官方：排序法
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        Arrays.asList(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 高斯算法
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        int actSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actSum += nums[i];
        }
        return sum - actSum;
    }
}
