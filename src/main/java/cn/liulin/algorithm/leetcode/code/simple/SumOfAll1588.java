package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1588. 所有奇数长度子数组的和
 * @author ll
 * @date 2022-11-21 14:01:26
 **/
public class SumOfAll1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int sum = 0;
        for (int i = 1; i <= length; i += 2) {
            for (int j = 0; j < length; j++) {
                int max = j + i;
                if (max > length) {
                    continue;
                }
                for (int k = j; k < max; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    public int sumOddLengthSubarrays2(int[] arr) {
        int length = arr.length;
        int[] prex = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            prex[i] = prex[i - 1] + arr[i - 1];
        }
        int sum = 0;
        for (int start = 0; start < length; start++) {
            for (int index = 1; start + index <= length; index += 2) {
                int end = start + index - 1;
                sum += prex[end + 1] - prex[start];
            }
        }
        return sum;
    }
}
