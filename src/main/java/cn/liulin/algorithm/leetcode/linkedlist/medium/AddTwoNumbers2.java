package cn.liulin.algorithm.leetcode.linkedlist.medium;

import cn.liulin.algorithm.leetcode.pojo.ListNode;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.medium$
 * 2. 两数相加
 * @author ll
 * @date 2022-08-05 09:23:57
 **/
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode result = l1;
        ListNode preNode = l1;
        while (l1 != null || l2 != null || pre != 0) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + pre;
            int val = sum % 10;
            pre = sum / 10;
            if (l1 != null) {
                preNode = l1;
                l1.val = val;
                l1 = l1.next;
            } else {
                ListNode temp = new ListNode(val);
                preNode.next = temp;
                preNode = temp;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }
}
