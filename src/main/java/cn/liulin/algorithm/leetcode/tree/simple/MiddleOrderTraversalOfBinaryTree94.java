package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 94. 二叉树的中序遍历
 * @author ll
 * @date 2022-06-17 20:47:05
 **/
public class MiddleOrderTraversalOfBinaryTree94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }

    }
}
