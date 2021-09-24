package cn.liulin.algorithm.leetcode.array.simple;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @author ll
 * @date 2021-09-24 11:00:40
 **/
public class AllArrayMissNum448 {
    /**
     * 自定义：哈希法
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            list.add(i);
        }
        for (int num : nums) {
            if (list.contains(num)) {
                list.remove(num);
            }
        }
        return new ArrayList<>(list);
    }

    /**
     * 鸽笼算法:
     * 因为Nums的长度就是区域[1, n]的n，且nums[i]在[1,n]中，所以nums的每个值-1刚好是角标值
     * 每个数字的值-1就是角标，将角标对应的值置为负数，则不是负数的数字所在角标+1的值肯定没出现
     * @author ll
     * @date 2021-09-24 11:31:53
     * @param nums
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 官方题解法：
     * @author ll
     * @date 2021-09-24 11:40:59
     * @param nums
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            //因为每一次循环Num的值都在变化，所以必须要对n取余，拿出原来的数
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        for (int num : nums) {
            nums[5] = 10;
            System.out.println(num);
        }
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        for (int num : list) {
            nums[1] = 10;
            System.out.println(num);
        }
    }
}
