package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 5. 最长回文子串
 * @author ll
 * @date 2022-10-26 16:35:27
 **/
public class LongestPalindromeSubstring5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int length = s.length();
        boolean[][] check = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            check[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = i - 1 + L;
                if (j >= length) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        check[i][j] = true;
                    } else {
                        check[i][j] = check[i + 1][j - 1];
                    }
                } else {
                    check[i][j] = false;
                }
                if (check[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
