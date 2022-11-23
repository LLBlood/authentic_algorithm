package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1309. 解码字母到整数映射
 * @author ll
 * @date 2022-11-22 18:09:27
 **/
public class DecodingLetter1309 {
    public String freqAlphabets(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (i + 1 < length) {
                char c1 = s.charAt(i + 1);
                if (i + 2 < length) {
                    char c2 = s.charAt(i + 2);
                    if (c2 == '#') {
                        String substring = s.substring(i, i + 2);
                        sb.append((char) (Integer.parseInt(substring) - 10 + 'j'));
                        i += 2;
                    } else {
                        sb.append((char) (c - '1' + 'a'));
                    }
                } else {
                    sb.append((char) (c - '1' + 'a'));
                    sb.append((char) (c1 - '1' + 'a'));
                    i++;
                }
            } else {
                sb.append((char) (c - '1' + 'a'));
            }
        }
        return sb.toString();
    }

    public String freqAlphabets2(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int index = length - 1;
        while (index >= 0) {
            char c = s.charAt(index);
            if (s.charAt(index) != '#') {
                sb.insert(0, (char) (c - '1' + 'a'));
                index--;
            } else {
                String substring = s.substring(index - 2, index);
                sb.insert(0, (char) (Integer.parseInt(substring) - 10 + 'j'));
                index -= 3;
            }
        }
        return sb.toString();
    }
}
