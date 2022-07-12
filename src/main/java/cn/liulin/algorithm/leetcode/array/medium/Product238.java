package cn.liulin.algorithm.leetcode.array.medium;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 238. 除自身以外数组的乘积
 * @author ll
 * @date 2022-07-12 16:44:24
 **/
public class Product238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
