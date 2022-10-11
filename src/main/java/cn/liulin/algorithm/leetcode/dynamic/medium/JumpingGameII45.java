package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 45. 跳跃游戏 II
 * @author ll
 * @date 2022-10-11 16:22:08
 **/
public class JumpingGameII45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxRight = 0;
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            maxRight = Math.max(maxRight, i + nums[i]);
            if (i == end) {
                end = maxRight;
                step++;
            }
        }
        return step;
    }
}
