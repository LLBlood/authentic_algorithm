package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1588. 所有奇数长度子数组的和
 * @author ll
 * @date 2022-01-21 14:27:57
 **/
public class SumOfAllOddLengthSubarrays1588 {

    /**
     * 暴力循环法
     * @author ll
     * @date 2022-01-21 14:46:04
     * @param arr
     * @return int
     **/
    public int sumOddLengthSubarrays(int[] arr) {
        int diff = 1;
        int sum = 0;
        while (diff <= arr.length) {
            int start = 0;
            while (start + diff <= arr.length) {
                for (int i = start; i < start + diff; i++) {
                    sum += arr[i];
                }
                start += 1;
            }
            diff += 2;
        }
        return sum;
    }
}
