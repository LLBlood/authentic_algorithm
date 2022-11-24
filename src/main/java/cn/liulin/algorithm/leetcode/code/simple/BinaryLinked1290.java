package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1290. 二进制链表转整数
 * @author ll
 * @date 2022-11-24 17:45:50
 **/
public class BinaryLinked1290 {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
