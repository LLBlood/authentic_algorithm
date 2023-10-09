package cn.liulin.algorithm.leetcode.array.simple;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 *
 * @author ll
 * @date 2023-10-09 15:16:43
 **/
public class SortOddAndEven2164 {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>(nums.length / 2), odd = new ArrayList<>(nums.length / 2);
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            }
            else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        odd.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < even.size(); ++i) {
            nums[2*i] = even.get(i);
        }
        for (int i = 0; i < odd.size(); ++i) {
            nums[2*i+1] = odd.get(i);
        }
        return nums;

    }
    public static void main(String[] args) {

    }
}
