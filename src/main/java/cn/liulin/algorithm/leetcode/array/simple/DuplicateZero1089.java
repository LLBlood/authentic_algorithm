package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1089. 复写零
 * 给你一个长度固定的整数数组arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
 * @author ll
 * @date 2021-11-01 15:31:14
 **/
public class DuplicateZero1089 {
    /**
     * 自定义：复写法
     * @author ll
     * @date 2021-11-01 16:01:17
     * @param arr
     * @return void
     **/
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j >= i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                if (i + 1 < arr.length) {
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }

    /**
     * 官方：两次遍历
     * @author ll
     * @date 2021-11-01 16:01:34
     * @param arr
     * @return void
     **/
    public void duplicateZeros2(int[] arr) {
        int duplicate = 0;
        int length = arr.length - 1;
        for (int left = 0; left <= length - duplicate; left++) {
            if (arr[left] == 0) {
                if (left == length - duplicate) {
                    arr[length] = 0;
                    length--;
                    break;
                }
                duplicate++;
            }
        }
        int last = length - duplicate;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + duplicate] = 0;
                duplicate--;
                arr[i + duplicate] = 0;
            } else {
                arr[i + duplicate] = arr[i];
            }
        }
    }
}
