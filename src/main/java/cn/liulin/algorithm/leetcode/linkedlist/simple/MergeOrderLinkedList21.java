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

import cn.liulin.algorithm.leetcode.pojo.ListNode;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 21. 合并两个有序链表
 * @author ll
 * @date 2022-06-14 17:43:07
 **/
public class MergeOrderLinkedList21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prey = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prey.next = list1;
                list1 = list1.next;
            } else {
                prey.next = list2;
                list2 = list2.next;
            }
            prey = prey.next;
        }
        prey.next = list1 == null ? list2 : list1;
        return prehead.next;
    }
}