package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 709. 转换成小写字母
 * @author ll
 * @date 2022-11-22 18:04:15
 **/
public class ConvertToLower709 {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar <= 'Z' && aChar >= 'A') {
                chars[i] = (char) (aChar + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }
}
