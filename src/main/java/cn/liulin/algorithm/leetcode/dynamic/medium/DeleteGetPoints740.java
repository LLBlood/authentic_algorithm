package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 740. 删除并获得点数
 * @author ll
 * @date 2022-10-10 15:39:40
 **/
public class DeleteGetPoints740 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int i : nums) {
            maxVal = Math.max(i, maxVal);
        }
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int first = sum[0];
        int second = Math.max(sum[0], sum[1]);
        for (int i = 2; i < sum.length; i++) {
            int temp = Math.max(first + sum[i], second);
            first = second;
            second = temp;
        }
        return Math.max(second, first);
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        new DeleteGetPoints740().deleteAndEarn(nums);
    }
}
