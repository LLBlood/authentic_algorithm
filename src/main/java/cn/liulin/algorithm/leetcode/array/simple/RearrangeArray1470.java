package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1470. 重新排列数组
 * @author ll
 * @date 2022-01-18 11:07:40
 **/
public class RearrangeArray1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index] = nums[i];
            index++;
            result[index] = nums[i + n];
            index++;
        }
        return result;
    }
}
