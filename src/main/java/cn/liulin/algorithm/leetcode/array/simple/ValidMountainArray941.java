package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 941. 有效的山脉数组
 * @author ll
 * @date 2021-10-28 15:01:01
 **/
public class ValidMountainArray941 {
    /**
     * 官方：线性扫描
     * @author ll
     * @date 2021-10-28 15:57:28
     * @param arr
     * @return boolean
     **/
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int endIndex = arr.length - 1;
        while (i + 1 <= endIndex && arr[i + 1] > arr[i]) {
            i++;
        }
        if (i == 0 || i == endIndex) {
            return false;
        }
        while (i + 1 <= endIndex && arr[i + 1] < arr[i]) {
            i++;
        }
        return i == endIndex;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,4,2,1};
        new ValidMountainArray941().validMountainArray(arr);
    }
}
