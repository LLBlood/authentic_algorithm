package cn.liulin.algorithm.leetcode.string.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 290. 单词规律
 * @author ll
 * @date 2022-07-19 11:35:24
 **/
public class RulesOfWords290 {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        Map<Character, String> map1 = new HashMap<>(s1.length);
        Map<String, Character> map2 = new HashMap<>(s1.length);
        if (s1.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map1.containsKey(c)) {
                String s2 = map1.get(c);
                if (!s2.equals(s1[i])) {
                    return false;
                }
            } else {
                map1.put(c, s1[i]);
            }
            if (map2.containsKey(s1[i])) {
                Character character = map2.get(s1[i]);
                if (!character.equals(c)) {
                    return false;
                }
            } else {
                map2.put(s1[i], c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('z' - 'a');
    }
}
