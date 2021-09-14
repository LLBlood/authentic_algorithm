package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author ll
 * @date 2021-09-14 18:03:17
 **/
public class AddOne66 {

    /**
     * 自定义：通过末位加1然后判断结果值
     * @author ll
     * @date 2021-09-14 18:37:58
     * @param digits
     * @return int[]
     **/
    public int[] plusOne(int[] digits) {
        int out = 1;
        int[] result = null;
        for (int i = digits.length - 1; i > 0; i--) {
            digits[i] = digits[i] + out;
            if (digits[i] > 9) {
                out = 1;
                digits[i] = digits[i] - 10;
            } else {
                out = 0;
                break;
            }
        }
        if (out > 0) {
            digits[0] = digits[0] + out;
            if (digits[0] > 9) {
                digits[0] = digits[0] - 10;
                result = new int[digits.length + 1];
                result[0] = 1;
                for (int i1 = 1; i1 < result.length; i1++) {
                    result[i1] = digits[i1 - 1];
                }
                return result;
            } else {
                return digits;
            }
        } else {
            return digits;
        }
    }

    /**
     * 结合实际法：如果数组每一位都是9才有可能增加1，否则在数组循环的时候就结束了
     * @author ll
     * @date 2021-09-14 18:40:33
     * @param digits
     * @return int[]
     **/
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环说明所有的值都是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
