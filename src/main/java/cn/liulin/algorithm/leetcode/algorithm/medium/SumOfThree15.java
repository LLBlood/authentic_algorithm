package cn.liulin.algorithm.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.algorithm.medium$
 * 15. 三数之和
 * @author ll
 * @date 2022-07-06 13:55:26
 **/
public class SumOfThree15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> allList = new LinkedList<>();
        Integer curValue = null;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (curValue != null && curValue == nums[i]) {
                continue;
            }
            curValue = nums[i];
            while (start < end) {
                int startValue = nums[start];
                int endValue = nums[end];
                int sum = curValue + startValue + endValue;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(curValue);
                    list.add(startValue);
                    list.add(endValue);
                    allList.add(list);
                    while (start < end && nums[start] == startValue) {
                        start++;
                    }
                    while (start < end && nums[end] == endValue) {
                        end--;
                    }
                } else if (sum < 0) {
                    while (start < end && nums[start] == startValue) {
                        start++;
                    }
                } else {
                    while (start < end && nums[end] == endValue) {
                        end--;
                    }
                }
            }
        }
        return allList;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = new SumOfThree15().threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num1 = nums[i];
            // 此处end设置在这里，是因为该数组是从小到大排列的，所以越在后面数值越大
            int end = nums.length - 1;
            int target = -num1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (end >= j + 1 && nums[j] + nums[end] > target) {
                    end--;
                }
                if (j == end) {
                    break;
                }
                if (nums[j] + nums[end] == target) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(num1);
                    temp.add(nums[j]);
                    temp.add(nums[end]);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
