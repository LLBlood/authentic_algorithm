package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * @author ll
 * @date 2021-10-12 10:34:15
 **/
public class KeyboardLine500 {
    /**
     * 自定义：暴力法
     * @author ll
     * @date 2021-10-12 10:48:54
     * @param words
     * @return java.lang.String[]
     **/
    public String[] findWords(String[] words) {
        String key1 = "qwertyuiop";
        String key2 = "asdfghjkl";
        String key3 = "zxcvbnm";
        int errorCount = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String tempKey = null;
            String s = word.toLowerCase();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (tempKey == null) {
                    if (key1.contains("" + aChar)) {
                        tempKey = key1;
                    } else if (key2.contains("" + aChar)) {
                        tempKey = key2;
                    } else {
                        tempKey = key3;
                    }
                } else {
                    if (!tempKey.contains("" + aChar)) {
                        words[i] = null;
                        errorCount++;
                        break;
                    }
                }
            }
        }
        String[] strings = new String[words.length - errorCount];
        int i = 0;
        for (String word : words) {
            if (word != null) {
                strings[i++] = word;
            }
        }
        return strings;
    }
}
