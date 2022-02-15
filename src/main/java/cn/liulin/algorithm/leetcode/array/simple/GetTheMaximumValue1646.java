package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1646. 获取生成数组中的最大值
 * @author ll
 * @date 2022-02-15 10:29:53
 **/
public class GetTheMaximumValue1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
