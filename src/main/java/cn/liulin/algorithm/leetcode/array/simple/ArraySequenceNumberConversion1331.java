package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1331. 数组序号转换
 * @author ll
 * @date 2021-11-12 13:30:56
 **/
public class ArraySequenceNumberConversion1331 {
    /**
     * 自定义：hash法
     * @author ll
     * @date 2021-11-12 13:45:14
     * @param arr
     * @return int[]
     **/
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        Arrays.sort(ans);
        Map<Integer, Integer> map = new HashMap<>();
        int sort = 1;
        for (int i = 0; i < ans.length; i++) {
            if (!map.containsKey(ans[i])) {
                map.put(ans[i], sort++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
