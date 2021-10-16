package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class WrongSet645 {
    /**
     * 自定义：纯数学法
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        long sum1 = (1 + nums.length) * nums.length / 2L;
        long sum2 = 0L;
        int rep = -1;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            sum2 += num;
            if (rep == -1 && !set.add(num)) {
                rep = num;
            }
        }
        int i = (int) ((sum1 - sum2) + rep);
        return new int[] {rep, i};
    }
}
