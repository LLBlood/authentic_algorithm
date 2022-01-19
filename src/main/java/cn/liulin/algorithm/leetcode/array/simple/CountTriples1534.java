package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1534. 统计好三元组
 * @author ll
 * @date 2022-01-19 09:56:27
 **/
public class CountTriples1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i] - a && arr[j] <= arr[i] + a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[k] >= arr[j] - b && arr[k] <= arr[j] + b) {
                            if (arr[k] >= arr[i] - c && arr[k] <= arr[i] + c) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
