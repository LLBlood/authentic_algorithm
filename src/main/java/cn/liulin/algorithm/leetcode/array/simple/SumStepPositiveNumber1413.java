package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1413. 逐步求和得到正数的最小值
 * @author ll
 * @date 2022-01-14 13:49:28
 **/
public class SumStepPositiveNumber1413 {
    public int minStartValue(int[] nums) {
        int end = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (end == 1) {
                if (num > 0) {
                    end = 1;
                } else {
                    end = 1 - num;
                }
            } else {
                if (num > 0) {
                    if (num >= end) {
                        end = 1;
                    } else {
                        end = end - num;
                    }
                } else {
                    end = end - num;
                }
            }
        }
        return end;
    }
}
