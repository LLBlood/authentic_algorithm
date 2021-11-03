package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * @author ll
 * @date 2021-11-03 17:48:27
 **/
public class MinimumAbsoluteDifference1200 {
    /**
     * 自定义：求最小值
     * @author ll
     * @date 2021-11-03 17:57:52
     * @param arr
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff > min) {
                continue;
            } else if (diff < min) {
                list.clear();
            }
            min = diff;
            List<Integer> temp = new ArrayList<>(2);
            temp.add(arr[i]);
            temp.add(arr[i + 1]);
            list.add(temp);
        }
        return list;
    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        //寻找最小绝对差
        for(int i = 0; i < n-1; ++i){
            if(arr[i+1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }
        //枚举所有符合条件的元素对
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n-1; ++i){
            if(arr[i+1] - arr[i] == min){
                ans.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return ans;
    }
}
