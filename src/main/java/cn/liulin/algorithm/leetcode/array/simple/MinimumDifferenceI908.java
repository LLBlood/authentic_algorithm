package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 908. 最小差值 I
 * 给你一个整数数组 nums，请你给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k），从而得到一个新数组 result 。
 * 返回数组 result 的最大值和最小值之间可能存在的最小差值。
 * @author ll
 * @date 2021-10-25 18:12:49
 **/
public class MinimumDifferenceI908 {
    /**
     * 自定义：数学法
     * @author ll
     * @date 2021-10-25 18:20:34
     * @param nums
     * @param k
     * @return int
     **/
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        return Math.max(maxNum - minNum - 2 * k, 0);
    }
}
