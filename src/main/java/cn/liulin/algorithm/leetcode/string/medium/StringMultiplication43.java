package cn.liulin.algorithm.leetcode.string.medium;

/**
 * cn.liulin.algorithm.leetcode.string.medium$
 * 43. 字符串相乘
 * @author ll
 * @date 2022-07-20 11:09:31
 **/
public class StringMultiplication43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        String sum = null;
        for (int i = chars1.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int ic = chars1[i] - '0';
            int pre = 0;
            for (int i1 = chars1.length - 1; i1 > i; i1--) {
                sb.append("0");
            }
            for (int j = chars2.length - 1; j >= 0; j--) {
                int jc = chars2[j] - '0';
                int z = ic * jc + pre;
                pre = z / 10;
                sb.append(z % 10);
            }
            if (pre != 0) {
                sb.append(pre);
            }
            if (sum == null) {
                sum = sb.reverse().toString();
            } else {
                String str = sb.reverse().toString();
                int sumI = sum.length() - 1, sumJ = str.length() - 1, add = 0;
                StringBuffer ans = new StringBuffer();
                while (sumI >= 0 || sumJ >= 0 || add != 0) {
                    int x = sumI >= 0 ? sum.charAt(sumI) - '0' : 0;
                    int y = sumJ >= 0 ? str.charAt(sumJ) - '0' : 0;
                    int result = x + y + add;
                    ans.append(result % 10);
                    add = result / 10;
                    sumI--;
                    sumJ--;
                }
                // 计算完以后的答案需要翻转过来
                sum = ans.reverse().toString();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String multiply = new StringMultiplication43().multiply("10", "100");
        System.out.println(multiply);
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
