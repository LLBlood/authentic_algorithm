package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author ll
 * @date 2021-09-14 10:19:14
 **/
public class MaximumSuborderSum53 {

    /**
     * 官方题解法：动态规划，保证Nums[i]与f{i-1} + nums[i]谁大谁小
     * @author ll
     * @date 2021-09-14 10:29:36
     * @param nums
     * @return int
     **/
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }

    /**
     * 官方题解法：分治法
     * @author ll
     * @date 2021-09-14 10:29:36
     * @param nums
     * @return int
     **/
    public int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(nums, l, m);
        Status rSub = getInfo(nums, m + 1, r);
        return pushUp(lSub, rSub);
    }

    private Status pushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rSum = Math.max(rSub.rSum, lSub.rSum + rSub.iSum);
        int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
}
