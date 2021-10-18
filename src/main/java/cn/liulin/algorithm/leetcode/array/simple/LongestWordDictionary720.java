package cn.liulin.algorithm.leetcode.array.simple;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * @author ll
 * @date 2021-10-18 14:57:11
 **/
public class LongestWordDictionary720 {
    public String longestWord(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word.length())) {
                map.get(word.length()).add(word);
            } else {
                List<String> str = new ArrayList<>(1);
                str.add(word);
                map.put(word.length(), str);
            }
        }
        List<String> str = null;
        int index = 0;
        int len = 1;
        while (index < map.size()) {
            if (map.containsKey(len)) {
                List<String> strings = map.get(len);
                if (str == null) {
                    str = strings;
                } else {
                    Iterator<String> iterator = str.iterator();
                    List<String> temp = new ArrayList<>();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        for (String string : strings) {
                            if (string.startsWith(next)) {
                                temp.add(string);
                            }
                        }
                    }
                    if (temp.isEmpty()) {
                        break;
                    }
                    str = temp;
                }
                index++;
                len++;
            } else {
                break;
            }
        }
        if (str == null || str.isEmpty()) {
            return "";
        } else if (str.size() == 1) {
            return str.get(0);
        } else {
            Collections.sort(str);
            return str.get(0);
        }
    }

    /**
     * 暴力法
     * @author ll
     * @date 2021-10-18 15:38:39
     * @param words
     * @return java.lang.String
     **/
    public String longestWord2(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>(words.length);
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if ((word.length() > ans.length()) ||
                    (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                boolean good = true;
                for (int i = 1; i < word.length(); i++) {
                    if (!set.contains(word.substring(0, i))) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}
