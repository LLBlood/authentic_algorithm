package cn.liulin.algorithm.leetcode.linkedlist.medium;


import cn.liulin.algorithm.leetcode.pojo.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.medium$
 * 82. 删除排序链表中的重复元素 II [1,2,3,3,4,4,5]
 * @author ll
 * @date 2022-08-08 17:37:32
 **/
public class DeleteList82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode out = new ListNode(-1);
        ListNode temp = out;
        while (head != null) {
            int val = head.val;
            if (head.next != null) {
                if (head.next.val != val) {
                    temp.next = new ListNode(val);
                    temp = temp.next;
                } else {
                    while (head.next != null && head.next.val == val) {
                        head = head.next;
                    }
                }
            } else {
                temp.next = new ListNode(val);
            }
            head = head.next;
        }
        return out.next;
    }
}
