package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 557. 反转字符串中的单词 III
 * @author ll
 * @date 2022-06-25 19:12:37
 **/
public class ReverseWordIII557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            int m = 0;
            int n = s2.length() - 1;
            char[] chars = s2.toCharArray();
            while (m < n) {
                char temp = chars[m];
                chars[m] = chars[n];
                chars[n] = temp;
                m++;
                n--;
            }
            sb.append(chars);
            if (i != s1.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int m = 0;
        int n = chars.length - 1;
        while (m < n) {
            char temp = chars[m];
            chars[m] = chars[n];
            chars[n] = temp;
            m++;
            n--;
        }
        String[] s1 = new String(chars).split(" ");
        m = 0;
        n = s1.length - 1;
        while (m < n) {
            String temp = s1[m];
            s1[m] = s1[n];
            s1[n] = temp;
            m++;
            n--;
        }
        return String.join(" ", s1);
    }

    public String reverseWords23(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
