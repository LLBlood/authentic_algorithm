package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1287. 有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 * @author ll
 * @date 2021-11-12 10:40:57
 **/
public class ElementsOrderArray1287 {
    /**
     * 自定义：全部遍历法
     * @author ll
     * @date 2021-11-12 11:24:23
     * @param arr
     * @return int
     **/
    public int findSpecialInteger(int[] arr) {
        int maxL = -1;
        int max = -1;
        int p = arr[0];
        int pL = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == p) {
                pL++;
            } else {
                if (pL > maxL) {
                    max = p;
                    maxL = pL;
                }
                p = arr[i];
                pL = 1;
            }
        }
        if (pL > maxL) {
            max = p;
        }
        return max;
    }

    /**
     * 遍历
     * @author ll
     * @date 2021-11-12 11:25:00
     * @param arr
     * @return int
     **/
    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int cur = arr[0], cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == cur) {
                ++cnt;
                if (cnt * 4 > n) {
                    return cur;
                }
            }
            else {
                cur = arr[i];
                cnt = 1;
            }
        }
        return -1;
    }
}
