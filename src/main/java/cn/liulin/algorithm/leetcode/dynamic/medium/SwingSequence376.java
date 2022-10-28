package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 376. 摆动序列
 * @author ll
 * @date 2022-10-28 13:50:21
 **/
public class SwingSequence376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                down = Math.max(up + 1, down);
            } else if (nums[i] < nums[i - 1]) {
                up = Math.max(down + 1, up);
            }
        }
        return Math.max(down, up);
    }
}
