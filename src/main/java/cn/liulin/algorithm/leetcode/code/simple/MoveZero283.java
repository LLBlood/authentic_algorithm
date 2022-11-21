package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 283. 移动零
 * @author ll
 * @date 2022-11-21 15:41:31
 **/
public class MoveZero283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    } else {
                        if (j == nums.length - 1) {
                            return;
                        }
                        j++;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = j > i ? j : i + 1;
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        j++;
                        break;
                    } else {
                        if (j == nums.length - 1) {
                            return;
                        }
                        j++;
                    }
                }
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
