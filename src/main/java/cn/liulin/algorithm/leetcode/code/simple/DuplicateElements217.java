package cn.liulin.algorithm.leetcode.code.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 217. 存在重复元素
 * @author ll
 * @date 2022-11-25 13:50:39
 **/
public class DuplicateElements217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
