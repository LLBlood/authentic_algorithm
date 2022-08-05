package cn.liulin.algorithm.leetcode.linkedlist.medium;

import cn.liulin.algorithm.leetcode.pojo.circular.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.medium$
 * 142. 环形链表 II
 * @author ll
 * @date 2022-08-05 09:51:28
 **/
public class CircularII142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            } else {
                map.put(head, 1);
                head = head.next;
            }
        }
        return null;
    }
}
