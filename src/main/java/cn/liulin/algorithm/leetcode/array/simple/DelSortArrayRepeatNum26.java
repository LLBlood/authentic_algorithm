package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组nums, 请你原地删除重复出现的元素，使每个元素只出现一次, 返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成
 * @author ll
 * @date 2021-09-09 11:16:18
 **/
public class DelSortArrayRepeatNum26 {

    /**
     * 自定义双指针法: 定义重复值对象，并设定新数组长度，使用角标不断递增查询值，若是不一样，则替换值
     * @author ll
     * @date 2021-09-09 13:49:53
     * @param nums
     * @return int
     **/
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int repeat = nums[0];
        //新数组长度
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != repeat) {
                repeat = nums[i];
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }

    /**
     * 官方双指针法：使用快指针和慢指针，快指针用于判定每个角标的值，满指针用于该数组准确的值
     * @author ll
     * @date 2021-09-09 13:50:12
     * @param nums
     * @return int
     **/
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
