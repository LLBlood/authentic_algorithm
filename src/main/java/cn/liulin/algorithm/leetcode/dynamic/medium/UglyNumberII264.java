package cn.liulin.algorithm.leetcode.dynamic.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 264.丑数 II
 * @author ll
 * @date 2022-10-19 09:35:44
 **/
public class UglyNumberII264 {
    public int nthUglyNumber(int n) {
        if (n <= 3) {
            return n;
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        int num = 3;
        int index = 4;
        while (index <= n) {
            num++;
            if ((num % 2 == 0 && set.contains(num / 2)) ||
                    (num % 5 == 0 && set.contains(num / 5)) ||
                    (num % 3 == 0 && set.contains(num / 3))) {
                index++;
                set.add(num);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int i = new UglyNumberII264().nthUglyNumber(1352);
        System.out.println(i);
    }

    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[p2] * 2;
            int num2 = dp[p3] * 3;
            int num3 = dp[p5] * 5;
            int min = Math.min(Math.min(num1, num2), num3);
            dp[i] = min;
            if (min == num1) {
                p2++;
            }
            if (min == num2) {
                p3++;
            }
            if (min == num3) {
                p5++;
            }
        }
        return dp[n];
    }
}
