package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * @author ll
 * @date 2021-10-25 18:03:48
 **/
public class SortArraysByParity905 {
    /**
     * 自定义：双指针法
     * @author ll
     * @date 2021-10-25 18:10:55
     * @param nums
     * @return int[]
     **/
    public int[] sortArrayByParity(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            while (nums[leftIndex] % 2 == 0 && leftIndex < rightIndex) {
                leftIndex++;
            }
            //此时LeftIndex为奇数
            while (nums[rightIndex] % 2 != 0 && leftIndex < rightIndex) {
                rightIndex--;
            }
            //此时rightIndex对应偶数
            //交换二者位置
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return nums;
    }
}
