package cn.liulin.algorithm.leetcode.string.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 387. 字符串中的第一个唯一字符
 * @author ll
 * @date 2022-06-13 16:04:58
 **/
public class FirstUniqueCharacter387 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int[] intChar = new int[26];
        for (char aChar : chars) {
            intChar[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (intChar[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        char[] cs = s.toCharArray();
        char[] chars = new char[128];
        for(int i = 0 ; i < cs.length; i++){
            chars[cs[i]]++;
        }
        for(int i = 0; i < cs.length; i++){
            if(chars[cs[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
