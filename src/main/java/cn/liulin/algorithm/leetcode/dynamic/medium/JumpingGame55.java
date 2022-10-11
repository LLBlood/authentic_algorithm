package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 55. 跳跃游戏
 * @author ll
 * @date 2022-10-11 15:54:45
 **/
public class JumpingGame55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int sum = 1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] < sum) {
                sum++;
            } else {
                sum = 1;
            }
        }
        return nums[0] >= sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        boolean b = new JumpingGame55().canJump(nums);
        System.out.println(b);
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
