package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 344. 反转字符串
 * @author ll
 * @date 2022-06-25 19:08:55
 **/
public class ReverseString344 {
    public void reverseString(char[] s) {
        int m = 0;
        int n = s.length - 1;
        while (m < n) {
            char temp = s[m];
            s[m] = s[n];
            s[n] = temp;
            m++;
            n--;
        }
    }
}
