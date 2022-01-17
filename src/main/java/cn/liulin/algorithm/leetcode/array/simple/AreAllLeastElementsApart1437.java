package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * @author ll
 * @date 2022-01-17 13:37:52
 **/
public class AreAllLeastElementsApart1437 {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        int i = 0;
        int j = nums.length - 1;
        int preI = -1;
        int preJ = -1;
        while (i < j) {
            if (nums[i] == 1) {
                if (preI == -1) {
                    preI = i;
                } else if (i - preI - 1 < k) {
                    return false;
                } else {
                    preI = i;
                }
            }
            i++;
            if (nums[j] == 1) {
                if (preJ == -1) {
                    preJ = j;
                } else if (preJ - j - 1 < k) {
                    return false;
                } else {
                    preJ = j;
                }
            }
            j--;
        }
        if (i == j && preI != -1 && preJ != -1) {
            return preJ - preI - 1 >= k;
        }
        return true;
    }
}
