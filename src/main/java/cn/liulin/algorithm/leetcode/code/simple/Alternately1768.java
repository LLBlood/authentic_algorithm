package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1768. 交替合并字符串
 * @author ll
 * @date 2022-11-22 10:14:04
 **/
public class Alternately1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < word1.length() || index < word2.length()) {
            if (index < word1.length() && index < word2.length()) {
                sb.append(word1.charAt(index));
                sb.append(word2.charAt(index));
                index++;
            } else if (index < word1.length()) {
                sb.append(word1.substring(index));
                break;
            } else  {
                sb.append(word2.substring(index));
                break;
            }
        }
        return sb.toString();
    }
}
