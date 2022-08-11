package cn.liulin.algorithm.leetcode.linkedlist.medium;

import cn.liulin.algorithm.leetcode.pojo.ListNode;

import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.medium$
 * 24. 两两交换链表中的节点
 * @author ll
 * @date 2022-08-11 16:08:00
 **/
public class SwitchTheNodes24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head.next;
        ListNode temp = null;
        while (head != null) {
            ListNode second = head.next;
            if (second == null) {
                return start;
            }
            ListNode third = head.next.next;
            head.next = third;
            second.next = head;
            if (temp != null) {
                temp.next = second;
            }
            temp = head;
            head = third;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        listNode.next = second;
        second.next = third;
        third.next = four;
        new SwitchTheNodes24().swapPairs(listNode);
    }
}
