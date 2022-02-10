package cn.liulin.algorithm.leetcode.array.simple;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1636. 按照频率将数组升序排序
 * @author ll
 * @date 2022-02-10 17:13:12
 **/
public class SortTheArrayInAscendingOrderByFrequency1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            int[] ints = {key, value};
            list.add(ints);
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            } else {
                return -1;
            }
        });
        int[] ints = new int[nums.length];
        int index = 0;
        for (int[] ints1 : list) {
            for (int i = 0; i < ints1[1]; i++) {
                ints[index++] = ints1[0];
            }
        }
        return ints;
    }
}
