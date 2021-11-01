package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1013. 将数组分成和相等的三个部分
 * @author ll
 * @date 2021-11-01 11:18:29
 **/
public class DivideArrayToThreePartsEquals1013 {
    /**
     * 官方：数学法
     * @author ll
     * @date 2021-11-01 13:58:50
     * @param arr
     * @return boolean
     **/
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return false;
        }
        int avg = sum / 3;
        int index = 0;
        int cur = 0;
        int n = arr.length;
        while (index < n) {
            cur += arr[index];
            if (cur == avg) {
                break;
            }
            index++;
        }
        if (cur != avg) {
            return false;
        }
        int j = index + 1;
        while (j < n - 1) {
            cur += arr[j];
            if (cur == avg * 2) {
                return true;
            }
            j++;
        }
        return false;
    }
}
