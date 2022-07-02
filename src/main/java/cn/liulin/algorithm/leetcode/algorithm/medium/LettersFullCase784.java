package cn.liulin.algorithm.leetcode.algorithm.medium;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.algorithm.medium$
 * 784. 字母大小写全排列
 * @author ll
 * @date 2022-07-02 19:15:34
 **/
public class LettersFullCase784 {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        list.add(s);
        letterCasePermutationToUpper(chars, list, 0);
        return list;
    }

    private void letterCasePermutationToUpper(char[] chars, List<String> list, int first) {
        if (first < chars.length) {
            if (chars[first] >= 'a' && chars[first] <= 'z') {
                chars[first] = (char) (chars[first] - 32);
                list.add(new String(chars));
                letterCasePermutationToUpper(chars, list, first + 1);
                chars[first] = (char) (chars[first] + 32);
                letterCasePermutationToUpper(chars, list, first + 1);
            } else if (chars[first] >= 'A' && chars[first] <= 'Z') {
                chars[first] = (char) (chars[first] + 32);
                list.add(new String(chars));
                letterCasePermutationToUpper(chars, list, first + 1);
                chars[first] = (char) (chars[first] - 32);
                letterCasePermutationToUpper(chars, list, first + 1);
            } else {
                letterCasePermutationToUpper(chars, list, first + 1);
            }
        }
    }

    public static void main(String[] args) {
        new LettersFullCase784().letterCasePermutation("a1b2");
    }
}
