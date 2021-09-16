package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 非递减顺序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * @author ll
 * @date 2021-09-16 10:41:52
 **/
public class TwoNumSumOrderArrayTwo167 {
    /**
     * 自定义：map存储
     * @author ll
     * @date 2021-09-16 11:02:28
     * @param numbers
     * @param target
     * @return int[]
     **/
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return null;
    }

    /**
     * 官方题解法：双指针法
     * @author ll
     * @date 2021-09-16 11:04:45
     * @param numbers
     * @param target
     * @return int[]
     **/
    public int[] twoSum2(int[] numbers, int target) {
        //双指针法
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    /**
     * 官方题解法：二分查找法
     * @author ll
     * @date 2021-09-16 11:12:18
     * @param numbers
     * @param target
     * @return int[]
     **/
    public int[] twoSum3(int[] numbers, int target) {
        //二分查找法
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1; int high = numbers.length - 1;
            while (low <= high) {
                int mid = (high + low) >> 1;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[] {i + 1, mid + 1};
                } else if (numbers[mid] < target - numbers[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return null;
    }
}
