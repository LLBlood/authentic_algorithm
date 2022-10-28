package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 300. 最长递增子序列
 * @author ll
 * @date 2022-10-28 11:33:30
 **/
public class LongestIncreasing300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int value1 = nums[i];
            for (int j = i + 1; j < n; j++) {
                int value2 = nums[j];
                if (value2 > value1) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] value = {0,1,0,3,2,3};
        int i = new LongestIncreasing300().lengthOfLIS2(value);
        System.out.println(i);
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int value1 = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int value2 = nums[j];
                if (value1 > value2) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
