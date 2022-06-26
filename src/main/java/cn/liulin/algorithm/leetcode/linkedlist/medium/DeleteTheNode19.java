package cn.liulin.algorithm.leetcode.linkedlist.medium;

import cn.liulin.algorithm.leetcode.pojo.remove.ListNode;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 * 19. 删除链表的倒数第 N 个结点
 * @author ll
 * @date 2022-06-26 20:40:56
 **/
public class DeleteTheNode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int sum = 0;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        int k = 0;
        ListNode preHead = null;
        temp = head;
        while (k != sum - n) {
            preHead = temp;
            temp = temp.next;
            k++;
        }
        if (preHead == null) {
            return head.next;
        } else {
            preHead.next = temp.next;
        }
        return head;
    }
}
