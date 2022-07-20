package cn.liulin.algorithm.leetcode.string.medium;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.string.medium$
 * 187. 重复的DNA序列
 * @author ll
 * @date 2022-07-20 14:39:37
 **/
public class RepeatedDNA187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() > 1) {
                result.add(stringIntegerEntry.getKey());
            }
        }

        return result;
    }
}
