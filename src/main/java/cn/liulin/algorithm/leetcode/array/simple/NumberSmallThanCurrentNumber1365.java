package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1365. 有多少小于当前数字的数字
 * @author ll
 * @date 2021-12-13 15:04:00
 **/
public class NumberSmallThanCurrentNumber1365 {
    /**
     * 计数排序
     * @author ll
     * @date 2021-12-13 15:21:01
     * @param nums
     * @return int[]
     **/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsArr = new int[500];
        for (int num : nums) {
            numsArr[num] += 1;
        }
        int[] re = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                re[i] += numsArr[j];
            }
        }
        return re;
    }
}
