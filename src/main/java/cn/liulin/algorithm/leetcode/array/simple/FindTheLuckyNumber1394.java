package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1394. 找出数组中的幸运数
 * @author ll
 * @date 2022-01-14 13:32:09
 **/
public class FindTheLuckyNumber1394 {
    public int findLucky(int[] arr) {
        int[] arrValue = new int[501];
        Arrays.fill(arrValue, 0);
        for (int i : arr) {
            arrValue[i] += 1;
        }
        for (int i = arrValue.length - 1; i > 0; i--) {
            if (arrValue[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
