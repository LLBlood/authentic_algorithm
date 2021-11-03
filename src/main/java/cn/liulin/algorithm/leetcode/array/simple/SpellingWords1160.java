package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1160. 拼写单词
 * @author ll
 * @date 2021-11-03 15:36:16
 **/
public class SpellingWords1160 {
    /**
     * 自定义：哈希表记数
     * @author ll
     * @date 2021-11-03 17:06:18
     * @param words
     * @param chars
     * @return int
     **/
    public int countCharacters(String[] words, String chars) {
        int length = 0;
        Map<Character, Long> charsColl = chars.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(x1 -> x1, Collectors.counting()));
        for (String word : words) {
            boolean flag = true;
            Map<Character, Long> wordColl = word.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(x1 -> x1, Collectors.counting()));
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (charsColl.getOrDefault(c, 0L) < wordColl.getOrDefault(c, 0L)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                length += word.length();
            }
        }
        return length;
    }

    public int countCharacters2(String[] words, String chars) {
        Map<Character, Integer> charsCnt = new HashMap<Character, Integer>();
        int length = chars.length();
        for (int i = 0; i < length; ++i) {
            char c = chars.charAt(i);
            charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCnt = new HashMap<Character, Integer>();
            int wordLength = word.length();
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
            }
            boolean isAns = true;
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                if (charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                ans += word.length();
            }
        }
        return ans;
    }
}
