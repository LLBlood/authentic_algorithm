package cn.liulin.algorithm.leetcode.code.medium;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 43. 字符串相乘
 * @author ll
 * @date 2022-12-08 14:47:40
 **/
public class StringMultiplication43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars = num2.toCharArray();
        String result = "0";
        int mul = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            int currentValue = aChar - '0';
            result = addResult(result, num1, currentValue, mul);
            mul++;
        }
        return result;
    }

    private String addResult(String first, String num1, int currentValue, int mul) {
        StringBuilder sb = new StringBuilder();
        char[] chars = num1.toCharArray();
        int more = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            int i1 = aChar - '0';
            int i2 = i1 * currentValue + more;
            int i3 = i2 % 10;
            sb.append(i3);
            more = i2 / 10;
        }
        if (more > 0) {
            sb.append(more);
        }
        sb.reverse();
        for (int i = 0; i < mul; i++) {
            sb.append(0);
        }
        char[] chars1 = sb.toString().toCharArray();
        StringBuilder result = new StringBuilder();
        int more1 = 0;
        int j = first.length() - 1;
        for (int i = chars1.length - 1; i >= 0; i--) {
            char c = chars1[i];
            int i1 = c - '0';
            int i2 = 0;
            if (j >= 0) {
                i2 = first.charAt(j) - '0';
                j--;
            }
            int i3 = i1 + i2 + more1;
            if (i3 >= 10) {
                result.append(i3 - 10);
                more1 = 1;
            } else {
                result.append(i3);
                more1 = 0;
            }
        }
        if (more1 > 0) {
            result.append(more1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        new StringMultiplication43().multiply("123", "456");
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}
