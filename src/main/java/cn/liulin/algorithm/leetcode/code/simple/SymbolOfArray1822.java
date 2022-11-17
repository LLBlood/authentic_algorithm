package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1822. 数组元素积的符号
 * @author ll
 * @date 2022-11-17 15:47:26
 **/
public class SymbolOfArray1822 {
    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num > 0) {
                result *= 1;
            } else if (num < 0) {
                result *= -1;
            } else {
                return 0;
            }
        }
        return result;
    }
}
