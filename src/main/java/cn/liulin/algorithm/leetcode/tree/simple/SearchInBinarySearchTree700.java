package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 700. 二叉搜索树中的搜索
 * @author ll
 * @date 2022-06-20 11:52:01
 **/
public class SearchInBinarySearchTree700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == val) {
                return poll;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
