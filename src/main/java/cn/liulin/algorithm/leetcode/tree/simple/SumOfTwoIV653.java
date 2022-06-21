package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 653. 两数之和 IV - 输入 BST
 * @author ll
 * @date 2022-06-21 14:34:30
 **/
public class SumOfTwoIV653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty() || root != null) {
            while (root != null) {
                queue.offer(root);
                root = root.left;
            }
            TreeNode poll = queue.poll();
            if (list.contains(k - poll.val)) {
                return true;
            } else {
                list.add(poll.val);
            }
            root = poll.right;
        }
        return false;
    }

    public boolean findTarget3(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}
