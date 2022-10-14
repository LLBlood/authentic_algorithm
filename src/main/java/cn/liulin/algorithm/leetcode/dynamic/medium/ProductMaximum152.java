package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 152. 乘积最大子数组
 * @author ll
 * @date 2022-10-14 11:02:49
 **/
public class ProductMaximum152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,-5,-2,-4,3};
        new ProductMaximum152().maxProduct(nums);
    }
}
