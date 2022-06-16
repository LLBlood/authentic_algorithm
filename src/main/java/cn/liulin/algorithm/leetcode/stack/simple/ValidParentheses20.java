package cn.liulin.algorithm.leetcode.stack.simple;

import java.util.Stack;

/**
 * cn.liulin.algorithm.leetcode.stack.simple$
 *
 * @author ll
 * @date 2022-06-16 17:29:33
 **/
public class ValidParentheses20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '[' || aChar == '(') {
                stack.add(aChar);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '{' && aChar != '}') {
                    return false;
                }
                if (pop == '[' && aChar != ']') {
                    return false;
                }
                if (pop == '(' && aChar != ')') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
