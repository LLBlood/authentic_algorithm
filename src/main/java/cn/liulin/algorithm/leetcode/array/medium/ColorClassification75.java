package cn.liulin.algorithm.leetcode.array.medium;

import com.alibaba.fastjson.JSON;

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

    public void sortColors2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == 0 && start < i) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            } else if (nums[i] == 2 && end > i) {
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new ColorClassification75().sortColors2(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
