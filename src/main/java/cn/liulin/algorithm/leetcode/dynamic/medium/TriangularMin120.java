package cn.liulin.algorithm.leetcode.dynamic.medium;

import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 120. 三角形最小路径和
 * @author ll
 * @date 2022-10-20 15:37:46
 **/
public class TriangularMin120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> integers = triangle.get(i);
            for (int j = 0; j < integers.size(); j++) {
                List<Integer> nextInt = triangle.get(i + 1);
                int best = Math.min(nextInt.get(j + 1), nextInt.get(j));
                integers.set(j, integers.get(j) + best);
            }
        }
        return triangle.get(0).get(0);
    }
}
