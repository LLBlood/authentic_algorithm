package cn.liulin.algorithm.leetcode.code.medium;

import cn.liulin.algorithm.leetcode.pojo.ListNode;
import cn.liulin.algorithm.leetcode.pojo.TreeNode;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 1367. 二叉树中的链表
 * @author ll
 * @date 2022-12-08 13:48:28
 **/
public class ListInBinary1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean leftB = false;
        boolean rightB = false;
        if (root.left != null) {
            leftB = isSubPath(head, root.left);
        }
        if (root.right != null) {
            rightB = isSubPath(head, root.right);
        }
        return def(head, root) || leftB || rightB;
    }

    private boolean def(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return def(head.next, root.left) || def(head.next, root.right);
    }
}
