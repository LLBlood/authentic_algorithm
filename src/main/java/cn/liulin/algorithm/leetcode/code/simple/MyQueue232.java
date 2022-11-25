package cn.liulin.algorithm.leetcode.code.simple;

import java.util.Stack;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 232. 用栈实现队列
 * @author ll
 * @date 2022-11-25 13:30:49
 **/
public class MyQueue232 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
