package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 876. 链表的中间结点
 * @author ll
 * @date 2022-11-24 17:55:33
 **/
public class IntermediateNode876 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode result = head.next;
        ListNode douNode = head.next.next;
        while (true) {
            if (douNode.next == null) {
                return result;
            } else if (douNode.next.next == null) {
                return result.next;
            } else {
                douNode = douNode.next.next;
                result = result.next;
            }
        }
    }
}
