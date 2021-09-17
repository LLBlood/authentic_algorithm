package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 * @author ll
 * @date 2021-09-17 10:27:14
 **/
public class DuplicateElementsTwo219 {
    /**
     * 自定义题解法：散列表
     * @author ll
     * @date 2021-09-17 10:34:30
     * @param nums
     * @param k
     * @return boolean
     **/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
