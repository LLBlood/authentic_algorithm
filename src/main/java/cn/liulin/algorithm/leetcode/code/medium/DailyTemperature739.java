package cn.liulin.algorithm.leetcode.code.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 739. 每日温度
 * @author ll
 * @date 2022-12-12 16:06:21
 **/
public class DailyTemperature739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] arr = new int[101];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; i--) {
            int a = temperatures[i];
            int warm = Integer.MAX_VALUE;
            for (int j = a + 1; j <= 100; j++) {
                if (arr[j] < warm) {
                    warm = arr[j];
                }
            }
            if (warm < Integer.MAX_VALUE) {
                ans[i] = warm - i;
            }
            arr[a] = i;
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

}
