package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 15. 三数之和
 * @author ll
 * @date 2022-07-27 16:42:37
 **/
public class SumOfThreeNumbers15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int firstValue = nums[i];
                int startIndex = i + 1;
                int endIndex = nums.length - 1;
                while (startIndex < endIndex) {
                    int sum = firstValue + nums[startIndex] + nums[endIndex];
                    if (sum == 0) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(firstValue);
                        tempList.add(nums[startIndex]);
                        tempList.add(nums[endIndex]);
                        list.add(tempList);
                        startIndex++;
                        endIndex--;
                    } else if (sum > 0) {
                        endIndex--;
                    } else {
                        startIndex++;
                    }
                    while (startIndex < endIndex && startIndex > i + 1 && nums[startIndex] == nums[startIndex - 1]) {
                        startIndex++;
                    }
                    while (startIndex < endIndex && endIndex < nums.length - 1 && nums[endIndex] == nums[endIndex + 1]) {
                        endIndex--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> lists = new SumOfThreeNumbers15().threeSum(nums);
        System.out.println(lists);
    }
}
