package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1512. 好数对的数目
 * @author ll
 * @date 2022-01-19 09:44:08
 **/
public class NumberOfGoodPairs1512 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numIdenticalPairs2(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            ans += value * (value - 1) / 2;
        }
        return ans;
    }
}
