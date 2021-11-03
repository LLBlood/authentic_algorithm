package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1207. 独一无二的出现次数
 * @author ll
 * @date 2021-11-03 18:02:14
 **/
public class UniqueOccurrences1207 {
    /**
     * 自定义：双hash法
     * @author ll
     * @date 2021-11-03 18:10:24
     * @param arr
     * @return boolean
     **/
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (!set.add(integerIntegerEntry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
