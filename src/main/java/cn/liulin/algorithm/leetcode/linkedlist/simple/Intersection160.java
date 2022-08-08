package cn.liulin.algorithm.leetcode.linkedlist.simple;

import cn.liulin.algorithm.leetcode.pojo.circular.ListNode;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 160. 相交链表
 * @author ll
 * @date 2022-08-08 17:15:49
 **/
public class Intersection160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (headA != null) {
            map.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
       ListNode A = headA;
       ListNode B = headB;
       while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
       }
       return A;
    }
}
