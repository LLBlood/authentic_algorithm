package cn.liulin.algorithm.leetcode.array.simple;
/**
* cn.liulin.algorithm.leetcode.array.simple$
* 977. 有序数组的平方
* @author ll
* @date 2021-10-29 13:13:49
**/
public class SquareOfOrderedArray977{
    /**
     * 自定义：双指针法
     * @author ll
     * @date 2021-10-29 13:29:28
     * @param nums
     * @return int[]
     **/
    public int[] sortedSquares(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int[] newArr = new int[nums.length];
        int index = newArr.length - 1;
        while (index >= 0) {
            if (Math.abs(nums[startIndex]) >= Math.abs(nums[endIndex])) {
                newArr[index] = (int) Math.pow(nums[startIndex], 2);
                startIndex++;
            } else {
                newArr[index] = (int) Math.pow(nums[endIndex], 2);
                endIndex--;
            }
            index--;
        }
        return newArr;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] ints = new int[nums.length];
        int x = 0;
        int y = nums.length - 1;
        int i = nums.length - 1;
        while (x <= y) {
            if (Math.abs(nums[x]) > Math.abs(nums[y])) {
                ints[i--] = nums[x] * nums[x];
                x++;
            } else {
                ints[i--] = nums[y] * nums[y];
                y--;
            }
        }
        return ints;
    }
}
