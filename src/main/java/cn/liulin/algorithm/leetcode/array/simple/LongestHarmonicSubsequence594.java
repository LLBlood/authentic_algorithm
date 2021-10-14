package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * @author ll
 * @date 2021-10-14 09:23:47
 **/
public class LongestHarmonicSubsequence594 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,3};
        int lhs2 = new LongestHarmonicSubsequence594().findLHS2(nums);
        System.out.println(lhs2);
    }

    /**
     * 自定义，完全暴力法
     * @author ll
     * @date 2021-10-14 10:06:20
     * @param nums
     * @return int
     **/
    public int findLHS(int[] nums) {
        int max = 0;
        int leftFlag = -1;
        int rightFlag = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int leftSize = 0;
            int rightSize = 0;
            boolean left = false;
            boolean right = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] == leftFlag) {
                    left = true;
                    leftSize++;
                } else if (nums[i] - nums[j] == 0) {
                    leftSize++;
                    rightSize++;
                } else if (nums[i] - nums[j] == rightFlag) {
                    right = true;
                    rightSize++;
                }
            }
            if (left && leftSize != 0) {
                max = Math.max(max, leftSize + 1);
            }
            if (right && rightSize != 0) {
                max = Math.max(max, rightSize + 1);
            }
        }
        return max;
    }

    /**
     * 将每个数当作最小的数，找出比它大一或者相等的数即可
     * @author ll
     * @date 2021-10-14 10:24:12
     * @param nums
     * @return int
     **/
    public int findLHS2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
                else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag)
                res = Math.max(count, res);
        }
        return res;
    }

    /**
     * 方法二：哈希映射
     * @author ll
     * @date 2021-10-14 10:24:57
     * @param nums
     * @return int
     **/
    public int findLHS3(int[] nums) {
        HashMap< Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

    /**
     * 哈希+一次扫描
     * @author ll
     * @date 2021-10-14 10:31:39
     * @param nums
     * @return int
     **/
    public int findLHS4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num) + map.get(num - 1));
            }
        }
        return res;
    }
}
