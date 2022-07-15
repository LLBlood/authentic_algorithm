package cn.liulin.algorithm.leetcode.array.medium;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 560. 和为 K 的子数组
 * @author ll
 * @date 2022-07-13 17:39:58
 **/
public class SubarrayK560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> preList = new ArrayList<>(nums.length);
        int sum = 0;
        for (int num : nums) {
            if (num == k) {
                sum++;
            }
            preList.add(num);
        }
        List<Integer> zeroList = new ArrayList<>(preList);

        for (int i = 1; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>(nums.length - i);
            int index = i;
            int start = 0;
            while (index < nums.length) {
                int num = preList.get(start++) + zeroList.get(index++);
                if (num == k) {
                    sum++;
                }
                list.add(num);
            }
            preList = list;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2;
        int i = new SubarrayK560().subarraySum(arr, k);
        System.out.println(i);
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
