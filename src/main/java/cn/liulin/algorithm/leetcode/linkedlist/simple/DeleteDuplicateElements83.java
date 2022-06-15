package cn.liulin.algorithm.leetcode.linkedlist.simple;

import cn.liulin.algorithm.leetcode.pojo.reverse.ListNode;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 83. 删除排序链表中的重复元素
 * @author ll
 * @date 2022-06-15 17:32:29
 **/
public class DeleteDuplicateElements83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return preHead;
    }
}
