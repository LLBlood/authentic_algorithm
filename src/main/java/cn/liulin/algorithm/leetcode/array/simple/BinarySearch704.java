package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * @author ll
 * @date 2021-10-18 11:11:32
 **/
public class BinarySearch704 {
    /**
     * 自定义：二分查找法
     * @author ll
     * @date 2021-10-18 11:21:39
     * @param nums
     * @param target
     * @return int
     **/
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            } else if (midNum < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int search = new BinarySearch704().search(nums, 2);
        System.out.println(search);
    }
}
