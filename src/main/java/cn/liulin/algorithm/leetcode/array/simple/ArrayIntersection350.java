package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 350. 两个数组的交集 II
 * @author ll
 * @date 2022-06-10 14:07:27
 **/
public class ArrayIntersection350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intList = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                intList.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        if (intList.isEmpty()) {
            return new int[] {};
        }
        int[] ints = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            ints[i] = intList.get(i);
        }
        return ints;
    }
}
