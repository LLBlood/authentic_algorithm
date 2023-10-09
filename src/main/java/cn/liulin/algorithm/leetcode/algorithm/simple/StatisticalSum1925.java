package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 *
 * @author ll
 * @date 2023-10-09 13:29:10
 **/
public class StatisticalSum1925 {
    public int countTriples(int n) {
        if (n < 5) {
            return 0;
        }
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int z = j + 1; z <= n; z++) {
                    if (i * i + j * j == z * z) {
                        System.out.println(i + " " + j + " " + z);
                        sum++;
                    }
                }
            }
        }
        return sum * 2;
    }

    public static void main(String[] args) {
        new StatisticalSum1925().countTriples(18);
    }
}
