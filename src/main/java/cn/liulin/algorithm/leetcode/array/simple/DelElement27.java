package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 27. 移除元素
 * 给你一个数组nums和一个值 val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author ll
 * @date 2021-09-10 15:13:13
 **/
public class DelElement27 {

    /**
     * 自定义双指针法，比较nt
     * @author ll
     * @date 2021-09-10 15:59:58
     * @param nums
     * @param val
     * @return int
     **/
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                nums[fast] = nums[slow];
            } else {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 官方双指针法: 其中一个指针负责存储返回的数据，另一个指针负责轮询数据
     * @author ll
     * @date 2021-09-10 16:01:53
     * @param nums
     * @param val
     * @return int
     **/
    public int removeElement2(int[] nums, int val) {
        int outIndex = 0;
        for (int oriIndex = 0; oriIndex < nums.length; oriIndex++) {
            if (nums[oriIndex] != val) {
                nums[outIndex] = nums[oriIndex];
                outIndex++;
            }
        }
        return outIndex;
    }

    /**
     * 官方双指针法2: 分左指针，右指针，左指针从左边开始，如果等于val，就与右指针对应的数交换，左右指针相等时结束循环
     * @author ll
     * @date 2021-09-10 16:01:53
     * @param nums
     * @param val
     * @return int
     **/
    public int removeElement3(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
