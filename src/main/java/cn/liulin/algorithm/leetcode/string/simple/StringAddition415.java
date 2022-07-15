package cn.liulin.algorithm.leetcode.string.simple;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 415. 字符串相加
 * @author ll
 * @date 2022-07-15 17:43:49
 **/
public class StringAddition415 {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if (n > m) {
            StringBuilder num2Builder = new StringBuilder(num2);
            for (int i = 0; i < (n - m); i++) {
                num2Builder.insert(0, "0");
            }
            num2 = num2Builder.toString();
        } else if (n < m) {
            StringBuilder num1Builder = new StringBuilder(num1);
            for (int i = 0; i < (m - n); i++) {
                num1Builder.insert(0, "0");
            }
            num1 = num1Builder.toString();
        }
        int pre = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int sum = num1.charAt(i) + num2.charAt(i) - 2 * '0' + pre;
            if (sum > 9) {
                sum -= 10;
                pre = 1;
            } else {
                pre = 0;
            }
            sb.insert(0, sum);
        }
        if (pre > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
