package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1619. 删除某些元素后的数组均值
 * @author ll
 * @date 2022-01-24 10:31:04
 **/
public class ArrayMeanAfter1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int res=arr.length/ 20;
        int ans=0;
        for (int i = res; i < arr.length-res; i++) {
            ans+=arr[i];
        }
        return ans*1.0/(arr.length-2*res);
    }
}
