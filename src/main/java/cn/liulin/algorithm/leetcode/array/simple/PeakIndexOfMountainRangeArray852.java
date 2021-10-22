package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 852. 山脉数组的峰顶索引
 * @author ll
 * @date 2021-10-22 10:32:42
 **/
public class PeakIndexOfMountainRangeArray852 {
    /**
     * 二分查找法，找出最小的大于下一个数的角标
     * @author ll
     * @date 2021-10-22 10:53:28
     * @param arr
     * @return int
     **/
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
