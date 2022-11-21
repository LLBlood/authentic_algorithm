package cn.liulin.algorithm.leetcode.code.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 496. 下一个更大元素 I
 * @author ll
 * @date 2022-11-18 17:48:01
 **/
public class NextLargerElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (flag && nums2[j] > nums1[i]) {
                    arr[i] = nums2[j];
                    break;
                } else if (nums2[j] == nums1[i]) {
                    flag = true;
                } else {
                    arr[i] = -1;
                }
            }
        }
        return arr;
    }


    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
