package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1018. 可被 5 整除的二进制前缀
 * 给定由若干0和1组成的数组 A。我们定义N_i：从A[0] 到A[i]的第 i个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表answer，只有当N_i可以被 5整除时，答案answer[i]为true，否则为 false。
 * @author ll
 * @date 2021-11-01 14:31:51
 **/
public class BinaryPrefixDivideByFive1018 {
    /**
     * 自定义：遍历法
     * @author ll
     * @date 2021-11-01 15:04:26
     * @param nums
     * @return java.util.List<java.lang.Boolean>
     **/
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> bStr = new ArrayList<>(nums.length);
        int binarySum = 0;
        for (int i = 0; i < nums.length; i++) {
            binarySum = binarySum * 2 + nums[i];
            if (binarySum % 5 == 0) {
                bStr.add(true);
            } else {
                bStr.add(false);
            }
            binarySum %= 5;
        }
        return bStr;
    }

    /**
     * 官方：遍历
     * @author ll
     * @date 2021-11-01 15:05:07
     * @param nums
     * @return java.util.List<java.lang.Boolean>
     **/
    public List<Boolean> prefixesDivBy52(int[] nums) {
        List<Boolean> bStr = new ArrayList<>(nums.length);
        int binarySum = 0;
        for (int i = 0; i < nums.length; i++) {
            binarySum = ((binarySum << 1) + nums[i]) % 5;
            bStr.add(binarySum == 0);
        }
        return bStr;
    }
}
