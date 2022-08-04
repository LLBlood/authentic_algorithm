package cn.liulin.algorithm.leetcode.string.medium;

/**
 * cn.liulin.algorithm.leetcode.string.medium$
 * 5. 最长回文子串
 * @author ll
 * @date 2022-08-04 09:30:58
 **/
public class Longest5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int left = 0;
            int right = left + i;
            while (right < chars.length) {
                StringBuilder sb = new StringBuilder();
                int start = left;
                int end = right;
                boolean flag = true;
                while (start < end) {
                    if (chars[start] == chars[end]) {
                        sb.append(chars[start]);
                        start++;
                        end--;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    String s1 = sb.toString();
                    sb.reverse();
                    if (start == end) {
                        sb.insert(0, chars[start]);
                    }
                    sb.insert(0, s1);
                    return sb.toString();
                } else {
                    left++;
                    right = left + i;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "abcba";
        String s = new Longest5().longestPalindrome(str);
        System.out.println(s);
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
