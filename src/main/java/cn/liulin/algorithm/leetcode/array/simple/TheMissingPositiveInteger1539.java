package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1539. 第 k 个缺失的正整数
 * @author ll
 * @date 2022-01-20 13:34:18
 **/
public class TheMissingPositiveInteger1539 {
    public int findKthPositive(int[] arr, int k) {
        int value = 0;
        int arrIndex = 0;
        while (k > 0) {
            value++;
            int i = arr[arrIndex];
            if (i != value) {
                k--;
            } else {
                arrIndex++;
                arrIndex = arrIndex == arr.length ? arrIndex - 1 : arrIndex;
            }
        }
        return value;
    }
}
