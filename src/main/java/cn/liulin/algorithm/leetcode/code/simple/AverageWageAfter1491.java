package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * @author ll
 * @date 2022-11-14 13:50:13
 **/
public class AverageWageAfter1491 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int length = salary.length;
        if (length == 2) {
            return 0;
        }
        int sum = 0;
        for (int i : salary) {
            sum += i;
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        return (sum - min - max) * 1.0 / (length - 2);
    }
}
