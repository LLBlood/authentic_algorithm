package cn.liulin.algorithm.leetcode.linkedlist.simple;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import cn.liulin.algorithm.leetcode.pojo.reverse.ListNode;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 206.反转链表
 * @author ll
 * @date 2022-06-15 17:09:40
 **/
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = new ListNode(-1);
        ListNode preList = null;
        while (head != null) {
            preList = head;
            head = head.next;
            preList.next = currentNode.next;
            currentNode = new ListNode(-1);
            currentNode.next = preList;
        }
        return currentNode.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = new ListNode(-1);
        while (head != null) {
            ListNode next = listNode.next;
            listNode.next = head;
            ListNode temp = head.next;
            head.next = next;
            head = temp;
        }
        return listNode.next;
    }
}
