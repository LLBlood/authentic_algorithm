package cn.liulin.algorithm.leetcode.array.medium;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 75. 颜色分类
 * @author ll
 * @date 2022-07-06 14:54:04
 **/
public class ColorClassification75 {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && start < i) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                i--;
                start++;
            } else if (nums[i] == 2 && end > i) {
                int temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                i--;
                end--;
            }
        }
    }
}
