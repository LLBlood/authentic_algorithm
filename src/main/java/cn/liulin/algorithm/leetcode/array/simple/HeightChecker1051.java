package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1051. 高度检查器
 * @author ll
 * @date 2021-11-01 15:08:50
 **/
public class HeightChecker1051 {
    /**
     * 自定义：排序对比法
     * @author ll
     * @date 2021-11-01 15:24:10
     * @param heights
     * @return int
     **/
    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            temp[i] = heights[i];
        }
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 桶排序法
     * @author ll
     * @date 2021-11-01 15:24:23
     * @param heights
     * @return int
     **/
    public int heightChecker2(int[] heights) {
        int[] temp = new int[101];
        for (int height : heights) {
            temp[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < temp.length; i++) {
            while (temp[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }
}
