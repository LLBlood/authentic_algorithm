package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 1567. 乘积为正数的最长子数组长度
 * @author ll
 * @date 2022-10-14 11:41:59
 **/
public class PositiveProduct1567 {
    public int getMaxLen(int[] nums) {
        int positiveLength = nums[0] > 0 ? 1 : 0;
        int negativeLength = nums[0] < 0 ? 1 : 0;
        int maxLength = positiveLength;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveLength++;
                negativeLength = negativeLength > 0 ? negativeLength + 1 : 0;
            } else if (nums[i] == 0) {
                positiveLength = 0;
                negativeLength = 0;
            } else {
                int newPositiveLength = negativeLength > 0 ? negativeLength + 1 : 0;
                int newNegativeLength = positiveLength + 1;
                positiveLength = newPositiveLength;
                negativeLength = newNegativeLength;
            }
            maxLength = Math.max(maxLength, positiveLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {-16,0,-5,2,2,-13,11,8};
        new PositiveProduct1567().getMaxLen(nums);
    }
}
