package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 191. 位1的个数
 * @author ll
 * @date 2022-11-15 13:44:03
 **/
public class NumberOfBitOne191 {
    public int hammingWeight(int n) {
        int count = 0;
        if (n == 0) {
            return 0;
        } else if (n > 0) {
            do {
                int z = n % 2;
                if (z == 1) {
                    count++;
                }
                n = n / 2;
            } while (n > 0);
        } else {
            n = n * -1;
            StringBuilder sb = new StringBuilder();
            do {
                int z = n % 2;
                if (z == 1) {
                    sb.insert(0, 1);
                } else {
                    sb.insert(0, 0);
                }
                n = n / 2;
            } while (n > 0);
            int length = sb.toString().length();
            for (int i = 1; i <= 31 - length; i++) {
                sb.insert(0, 0);
            }
            sb.insert(0, 1);
            String s = sb.toString();
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                chars[i] = chars[i] == '1' ? '0' : '1';
            }
            if (chars[chars.length - 1] == '1') {
                chars[chars.length - 1] = '0';
                for (int i = chars.length - 2; i >= 1; i--) {
                    if (chars[i] == '1') {
                        chars[i] = '0';
                    } else {
                        chars[i] = '1';
                        break;
                    }
                }
            } else {
                chars[chars.length - 1] = '1';
            }
            for (char aChar : chars) {
                if (aChar == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        for(int i = 0; i <= 31; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }

    public int hammingWeight3(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        new NumberOfBitOne191().hammingWeight(-3);
    }
}
