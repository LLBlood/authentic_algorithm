package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1。两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * @author ll
 * @date 2021-09-09 10:40:34
 **/
public class TwoNumSum1 {
    /**
     * 暴力破解法，取出数组中的每一个数，然后与后面的数相加对比是否为target
     * 速度慢O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 利用hashMap，将查询过的每一个数存储起来，查询target-x的结果是否在hashMap中存在
     * 速度可以O(n)
     * @author ll
     * @date 2021-09-09 11:10:13
     * @param nums
     * @param target
     * @return int[]
     **/
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
