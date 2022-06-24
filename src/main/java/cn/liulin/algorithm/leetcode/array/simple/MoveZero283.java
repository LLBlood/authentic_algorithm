package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @author ll
 * @date 2021-09-09 10:40:34
 **/
public class MoveZero283 {
    /**
     * 自定义：强行记录法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针法：左值针left指向已处理数据尾部，右指针指向未处理头部，左右指针之间的区域就是0
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length; int left = 0; int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
