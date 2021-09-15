package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @author ll
 * @date 2021-09-15 10:18:17
 **/
public class MergeTwoOrderArray88{
    /**
     * 自定义：双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = 0;
        int nums2Index = 0;
        int z = 0;
        int[] temp = new int[m+n];
        while (z < m + n) {
            if (nums1Index < m && nums2Index < n) {
                if (nums1[nums1Index] <= nums2[nums2Index]) {
                    temp[z] = nums1[nums1Index];
                    nums1Index++;
                } else {
                    temp[z] = nums2[nums2Index];
                    nums2Index++;
                }
            } else if (nums1Index < m) {
                temp[z] = nums1[nums1Index];
                nums1Index++;
            } else {
                temp[z] = nums2[nums2Index];
                nums2Index++;
            }
            z++;
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    /**
     * 官方：双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = 0;
        int nums2Index = 0;
        int cur = 0;
        int[] temp = new int[m+n];
        while (nums1Index < m || nums2Index < n) {
            if (nums1Index == m) {
                cur = nums2[nums2Index++];
            } else if (nums2Index == n) {
                cur = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                cur = nums1[nums1Index++];
            } else {
                cur = nums2[nums2Index++];
            }
            temp[nums1Index + nums2Index - 1] = cur;
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    /**
     * 官方：逆双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (nums1Index >= 0 || nums2Index >= 0) {
            if (nums1Index == -1) {
                cur = nums2[nums2Index--];
            } else if (nums2Index == -1) {
                cur = nums1[nums1Index--];
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                cur = nums1[nums1Index--];
            } else {
                cur = nums2[nums2Index--];
            }
            nums1[tail--] = cur;
        }
    }
}
