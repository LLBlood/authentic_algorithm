package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 804. 唯一摩尔斯密码词
 * @author ll
 * @date 2021-10-21 11:41:58
 **/
public class UniqueMorseCodeWord804{
    /**
     * 自定义：哈希集合
     * @author ll
     * @date 2021-10-21 11:48:37
     * @param words
     * @return int
     **/
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morses[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
    }
}
