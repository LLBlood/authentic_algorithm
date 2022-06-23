package cn.liulin.algorithm.leetcode.array.medium;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 189. 轮转数组
 * @author ll
 * @date 2022-06-23 18:01:02
 **/
public class RotationArray189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k > 0) {
            int[] newNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int z = (i + k) % nums.length;
                newNums[z] = nums[i];
            }
            System.arraycopy(newNums, 0, nums, 0, newNums.length);
        }

    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
