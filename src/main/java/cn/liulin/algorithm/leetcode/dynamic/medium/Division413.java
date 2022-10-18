package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 413. 等差数列划分
 * @author ll
 * @date 2022-10-18 15:19:55
 **/
public class Division413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int[] dp = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            dp[i] = nums[i + 1] - nums[i];
        }
        int size = 1;
        int value = dp[0];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == value) {
                size++;
            } else {
                if (size >= 2) {
                    max += size * (size - 1) / 2;
                }
                value = dp[i];
                size = 1;
            }
        }
        if (size >= 2) {
            max += size * (size - 1) / 2;
        }
        return max;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int d = nums[0] - nums[1];
        int t = 0;
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if (d == nums[i - 1] - nums[i]) {
                t++;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,8,9,10};
        new Division413().numberOfArithmeticSlices(nums);
    }
}
