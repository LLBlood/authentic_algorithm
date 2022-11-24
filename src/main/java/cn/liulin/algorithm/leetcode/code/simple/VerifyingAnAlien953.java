package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 953. 验证外星语词典
 * @author ll
 * @date 2022-11-24 17:07:55
 **/
public class VerifyingAnAlien953 {
    public boolean isAlienSorted(String[] words, String order) {
        int length = words.length;
        for (int i = 0; i < length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int index = 0;
            while (index < word1.length() && index < word2.length()) {
                char c1 = word1.charAt(index);
                int z1 = order.indexOf(c1);
                char c2 = word2.charAt(index);
                int z2 = order.indexOf(c2);
                if (z2 < z1) {
                    return false;
                } else if (z1 < z2) {
                    break;
                }
                if (index + 1 >= word1.length() || index + 1 >= word2.length()) {
                    if (word2.length() < word1.length()) {
                        return false;
                    }
                }
                index++;
            }
        }
        return true;
    }
}
