package cn.liulin.algorithm.leetcode.code.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1502. 判断能否形成等差数列
 * @author ll
 * @date 2022-11-17 16:30:00
 **/
public class JudgeWhether1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) {
            return true;
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) {
                return false;
            }
        }
        return true;
    }
}
