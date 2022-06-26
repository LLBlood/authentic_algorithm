package cn.liulin.algorithm.leetcode.linkedlist.simple;

import cn.liulin.algorithm.leetcode.pojo.remove.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 876. 链表的中间结点
 * @author ll
 * @date 2022-06-26 20:34:01
 **/
public class NodeOfLinkedList876 {
    public ListNode middleNode(ListNode head) {
            List<ListNode> list = new LinkedList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            return list.get(list.size() / 2);
    }
}
