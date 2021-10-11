package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 453. 最小操作次数使数组元素相等
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 * @author ll
 * @date 2021-10-11 16:23:03
 **/
public class MinOperaArrayEqualsElements453 {

    /**
     * 官方数学法：给数组除某个元素外的所有元素+1，即对该元素进行-1
     * 首先找出最小的数，然后算出每个数变更到最小数的次数
     * @author ll
     * @date 2021-10-11 16:36:49
     * @param nums
     * @return int
     **/
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            min = Math.min(min, num);
            count += num - min;
        }
        return count;
    }
}
