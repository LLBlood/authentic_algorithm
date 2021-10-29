package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 953. 验证外星语词典
 * @author ll
 * @date 2021-10-29 11:23:37
 **/
public class VerifyAlienLanguageDic953 {
    /**
     * 自定义：检查邻近单词
     * @author ll
     * @date 2021-10-29 13:11:46
     * @param words
     * @param order
     * @return boolean
     **/
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;
            boolean flag = false;
            while (j < word1.length() && j < word2.length()) {
                int i1 = order.indexOf(word1.charAt(j));
                int i2 = order.indexOf(word2.charAt(j));
                j++;
                if (i1 > i2) {
                    return false;
                } else if (i1 < i2) {
                    flag = true;
                    break;
                }
            }
            if (!flag && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"kuvp","q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        new VerifyAlienLanguageDic953().isAlienSorted(words, order);
    }
}
