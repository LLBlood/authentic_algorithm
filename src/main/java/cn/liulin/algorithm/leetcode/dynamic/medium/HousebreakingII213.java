package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 213. 打家劫舍 II
 * @author ll
 * @date 2022-10-10 15:15:54
 **/
public class HousebreakingII213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int firstOne = nums[0];
        int secondOne = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = Math.max(nums[i] + firstOne, secondOne);
            firstOne = secondOne;
            secondOne = temp;
        }
        if (nums.length > 2) {
            int firstTwo = nums[1];
            int secondTwo = Math.max(nums[1], nums[2]);
            for (int i = 3; i < nums.length; i++) {
                int temp = Math.max(nums[i] + firstTwo, secondTwo);
                firstTwo = secondTwo;
                secondTwo = temp;
            }
            return Math.max(Math.max(firstOne, secondOne), Math.max(firstTwo, secondTwo));
        }
        return Math.max(firstOne, secondOne);
    }
}
