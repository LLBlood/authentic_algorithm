package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author ll
 * @date 2021-09-10 16:33:24
 **/
public class SearchInsertPosition35 {

    /**
     * 自定义二分查找法：不再详细描述
     * @author ll
     * @date 2021-09-10 16:51:51
     * @param nums
     * @param target
     * @return int
     **/
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }

    /**
     * 官方二分查找法
     * @author ll
     * @date 2021-09-10 16:52:16
     * @param nums
     * @param target
     * @return int
     **/
    public int searchInsert2(int[] nums, int target) {
        int ans = nums.length;
        int left = 0;
        int right = ans - 1;
        while (left <= right) {
            int middle = ((left + right) >> 1);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                ans = middle;
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return ans;
    }

    public int searchInsert3(int[] nums, int target) {
        int x = 0;
        int y = nums.length - 1;
        while (x <= y) {
            int mid = x + (y - x) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                y = mid - 1;
            } else {
                x = mid + 1;
            }
        }
        return x;
    }
}
