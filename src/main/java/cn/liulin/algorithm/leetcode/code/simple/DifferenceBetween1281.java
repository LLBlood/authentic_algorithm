package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1281. 整数的各位积和之差
 * @author ll
 * @date 2022-11-15 15:55:57
 **/
public class DifferenceBetween1281 {
    public int subtractProductAndSum(int n) {
        String s = n + "";
        int product = 1;
        int sum = 0;
        for (char c : s.toCharArray()) {
            product *= (c - '0');
            sum += (c - '0');
        }
        return product - sum;
    }

    public int subtractProductAndSum2(int n) {
        int add = 0, mul = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            add += digit;
            mul *= digit;
        }
        return mul - add;
    }
}
