package cn.liulin.algorithm.leetcode.array.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * @author ll
 * @date 2021-09-09 10:40:34
 **/
public class SummaryInterval228 {
    /**
     * 自定义版本： 顺序遍历
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if (nums.length == 0) {
            return list;
        }
        int startIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (startIndex == i - 1) {
                    list.add(String.valueOf(nums[startIndex]));
                } else {
                    list.add(nums[startIndex] + "->" + nums[i - 1]);
                }
                startIndex = i;
            }
        }
        if (startIndex == nums.length - 1) {
            list.add(String.valueOf(nums[startIndex]));
        } else {
            list.add(nums[startIndex] + "->" + nums[nums.length - 1]);
        }
        return list;
    }
}
