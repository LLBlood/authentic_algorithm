package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 226. 翻转二叉树
 * @author ll
 * @date 2022-06-19 18:47:28
 **/
public class FlipBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
