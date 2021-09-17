package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.simple$\
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @author ll
 * @date 2021-09-17 10:19:17
 **/
public class DuplicateElements217 {

    /**
     * 官方题解法：哈希
     * @author ll
     * @date 2021-09-17 10:24:24
     * @param nums
     * @return boolean
     **/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
