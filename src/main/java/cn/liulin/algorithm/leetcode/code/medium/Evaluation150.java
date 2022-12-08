package cn.liulin.algorithm.leetcode.code.medium;

import java.util.Stack;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 150. 逆波兰表达式求值
 * @author ll
 * @date 2022-12-08 13:26:00
 **/
public class Evaluation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Integer rightNum = null;
            Integer leftNum = null;
            switch (token) {
                case "+":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum + rightNum);
                    break;
                case "-":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum - rightNum);
                    break;
                case "*":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum * rightNum);
                    break;
                case "/":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum / rightNum);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
