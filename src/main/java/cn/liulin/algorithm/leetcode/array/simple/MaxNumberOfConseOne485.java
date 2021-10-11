package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * @author ll
 * @date 2021-10-11 17:35:30
 **/
public class MaxNumberOfConseOne485 {
    /**
     * 自定义法：一次遍历
     * @author ll
     * @date 2021-10-11 17:45:55
     * @param nums
     * @return int
     **/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                size++;
            } else {
                max = Math.max(max, size);
                size = 0;
            }
        }
        max = Math.max(max, size);
        return max;
    }
}
