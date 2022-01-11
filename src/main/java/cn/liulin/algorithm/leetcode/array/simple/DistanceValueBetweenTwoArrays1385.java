package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1385. 两个数组间的距离值
 * @author ll
 * @date 2022-01-11 16:38:19
 **/
public class DistanceValueBetweenTwoArrays1385 {

    /**
     * 模拟
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int[][] maiArr = new int[arr1.length][2];
        for (int i = 0; i < arr1.length; i++) {
            int cu = arr1[i];
            maiArr[i][0] = cu - d;
            maiArr[i][1] = cu + d;
        }
        int sum = 0;
        for (int[] ints : maiArr) {
            sum++;
            for (int i : arr2) {
                if (i >= ints[0] && i <= ints[1]) {
                    sum--;
                    break;
                }
            }
        }
        return sum;
    }

    /**
     * 模拟
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int i : arr1) {
            boolean ok = true;
            for (int i1 : arr2) {
                ok &= Math.abs(i - i1) > d;
                if (!ok) {
                    break;
                }
            }
            if (ok) {
                cnt += ok ? 1 : 0;
            }
        }
        return cnt;
    }

    /**
     * 二分查找法
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue3(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;
            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) >> 1 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
