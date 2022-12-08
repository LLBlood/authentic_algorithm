package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 66. 加一
 * @author ll
 * @date 2022-12-08 13:38:51
 **/
public class AddOne66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int diff = 1;
        for (int i = length - 1; i >= 0; i--) {
            int digit = digits[i];
            int result = digit + diff;
            if (result == 10) {
                digits[i] = 0;
            } else {
                digits[i] = result;
                diff = 0;
                break;
            }
        }
        if (diff == 1) {
            int[] newInt = new int[length + 1];
            newInt[0] = 1;
            for (int i = 1; i < newInt.length; i++) {
                newInt[i] = digits[i - 1];
            }
            return newInt;
        }
        return digits;
    }
}
