package cn.liulin.algorithm.leetcode.array.medium;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 334. 递增的三元子序列
 * @author ll
 * @date 2022-07-12 15:03:59
 **/
public class Increasing334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }

    public boolean increasingTriplet3(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int num1 = nums[0];
        int num2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > num2) {
                return true;
            } else if (nums[i] <= num1) {
                num1 = nums[i];
            } else if (nums[i] <= num2) {
                num2 = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,-2,6};
        new Increasing334().increasingTriplet3(nums);
    }
}
