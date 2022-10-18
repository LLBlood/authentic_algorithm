package cn.liulin.algorithm.leetcode.dynamic.hard;

/**
 * cn.liulin.algorithm.leetcode.dynamic.hard$
 * 42. 接雨水
 * @author ll
 * @date 2022-10-18 13:40:04
 **/
public class RainwaterConnection42 {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 此处等价于leftMax < rightMax，因为每次对比只存在一个角标的变更
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        new RainwaterConnection42().trap(nums);
    }
}
