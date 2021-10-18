package cn.liulin.algorithm.leetcode.array.simple;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * @author ll
 * @date 2021-10-18 10:40:34
 **/
public class DegreeOfArray697 {
    /**
     * 自定义：三MAP法
     * @author ll
     * @date 2021-10-18 11:03:24
     * @param nums
     * @return int
     **/
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (!startMap.containsKey(num)) {
                startMap.put(num, i);
            }
            endMap.put(num, i);
        }
        List<Integer> integers = new ArrayList<>(countMap.values());
        Collections.sort(integers);
        Integer max = integers.get(integers.size() - 1);
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : countMap.entrySet()) {
            if (integerIntegerEntry.getValue().equals(max)) {
                int i = endMap.get(integerIntegerEntry.getKey()) - startMap.get(integerIntegerEntry.getKey()) + 1;
                min = Math.min(i, min);
            }
        }
        return min;
    }

    /**
     * 官方：单Map
     * @author ll
     * @date 2021-10-18 11:03:42
     * @param nums
     * @return int
     **/
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, int[]> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (countMap.containsKey(num)) {
                countMap.get(num)[0] += 1;
                countMap.get(num)[2] = i;
            } else {
                countMap.put(num, new int[] {1, i, i});
            }
        }
        int max = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> integerEntry : countMap.entrySet()) {
            Integer key = integerEntry.getKey();
            int[] value = integerEntry.getValue();
            if (max < value[0]) {
                max = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (max == value[0]) {
                if (minLen > value[2] - value[1] + 1) {
                    minLen = value[2] - value[1] + 1;
                }
            }
        }
        return minLen;
    }
}
