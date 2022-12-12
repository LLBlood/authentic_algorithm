package cn.liulin.algorithm.leetcode.code.simple;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 58. 最后一个单词的长度
 * @author ll
 * @date 2022-12-12 17:46:07
 **/
public class LengthLast58 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int size = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c != ' ') {
                size++;
            } else if (size != 0) {
                return size;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        String[] s1 = "   fly me   to   the moon  ".split(" ");
        System.out.println(JSON.toJSONString(s1));
    }
}
