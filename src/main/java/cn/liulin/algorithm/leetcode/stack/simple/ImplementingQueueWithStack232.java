package cn.liulin.algorithm.leetcode.stack.simple;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Stack;

/**
 * cn.liulin.algorithm.leetcode.stack.simple$
 * 232. 用栈实现队列
 * @author ll
 * @date 2022-06-16 18:09:40
 **/
public class ImplementingQueueWithStack232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public ImplementingQueueWithStack232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
