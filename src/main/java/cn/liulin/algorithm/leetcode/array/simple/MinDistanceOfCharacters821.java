package cn.liulin.algorithm.leetcode.array.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * @author ll
 * @date 2021-10-22 09:53:04
 **/
public class MinDistanceOfCharacters821 {
    /**
     * 自定义：对比法
     * @author ll
     * @date 2021-10-22 10:08:53
     * @param s
     * @param c
     * @return int[]
     **/
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                list.add(i);
            }
        }
        int[] answer = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer integer : list) {
                min = Math.min(Math.abs(i - integer), min);
            }
            answer[i] = min;
        }
        return answer;
    }

    /**
     * 最小数组
     * @author ll
     * @date 2021-10-22 10:11:46
     * @param s
     * @param c
     * @return int[]
     **/
    public int[] shortestToChar2(String s, char c) {
        char[] chars = s.toCharArray();
        int[] answer = new int[s.length()];
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                prev = i;
            }
            answer[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == c) {
                prev = i;
            }
            answer[i] = Math.min(answer[i], prev - i);
        }
        return answer;
    }
}
