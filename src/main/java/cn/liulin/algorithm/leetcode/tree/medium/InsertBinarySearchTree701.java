package cn.liulin.algorithm.leetcode.tree.medium;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 700. 二叉搜索树中的搜索
 * @author ll
 * @date 2022-06-20 11:52:01
 **/
public class InsertBinarySearchTree701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode oriRoot = root;
        TreeNode parentNode = root;
        while (root != null) {
            parentNode = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        if (parentNode.val < val) {
            parentNode.right = new TreeNode(val);
        } else {
            parentNode.left = new TreeNode(val);
        }
        return oriRoot;
    }
}
