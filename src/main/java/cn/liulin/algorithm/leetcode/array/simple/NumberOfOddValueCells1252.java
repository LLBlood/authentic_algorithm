package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1252. 奇数值单元格的数目
 * @author ll
 * @date 2021-11-05 09:48:49
 **/
public class NumberOfOddValueCells1252 {
    /**
     * 自定义：数学法
     * @author ll
     * @date 2021-11-05 11:09:03
     * @param m
     * @param n
     * @param indices
     * @return int
     **/
    public int oddCells(int m, int n, int[][] indices) {
        Map<Integer, Integer> xMap = new HashMap<>(m);
        Map<Integer, Integer> yMap = new HashMap<>(n);

        for (int[] index : indices) {
            int x = index[0];
            int y = index[1];
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }
        int xCount = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : xMap.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value % 2 != 0) {
                xCount += 1;
            }
        }
        int yCount = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : yMap.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value % 2 != 0) {
                yCount += 1;
            }
        }
        return xCount * n + yCount * m - 2 * xCount * yCount;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1},{0,0}};
        new NumberOfOddValueCells1252().oddCells(2, 2, arr);
    }
}
