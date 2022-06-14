package cn.liulin.algorithm.leetcode.linkedlist.simple;

import cn.liulin.algorithm.leetcode.pojo.remove.ListNode;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 203. 移除链表元素
 * @author ll
 * @date 2022-06-14 22:09:43
 **/
public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preNode = new ListNode(-1);
        ListNode nextNode = preNode;
        while (head != null) {
            if (head.val != val) {
                nextNode.next = head;
                nextNode = nextNode.next;
            } else {
                nextNode.next = null;
            }
            head = head.next;
        }
        return preNode.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
