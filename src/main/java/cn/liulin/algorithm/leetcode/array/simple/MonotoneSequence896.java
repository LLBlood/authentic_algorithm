package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 * @author ll
 * @date 2021-10-25 17:51:20
 **/
public class MonotoneSequence896 {
    /**
     * 自定义：数学法
     * @author ll
     * @date 2021-10-25 18:01:30
     * @param nums
     * @return boolean
     **/
    public boolean isMonotonic(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1] - nums[i];
            if (diff == 0) {
                diff = temp;
            } else if (diff < 0 && temp > 0) {
                return false;
            } else if (diff > 0 && temp < 0) {
                return false;
            }
        }
        return true;
    }
}
