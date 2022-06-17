package cn.liulin.algorithm.leetcode.tree.simple;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 144. 二叉树的前序遍历
 * @author ll
 * @date 2022-06-17 20:38:37
 **/
public class PreorderTraversalOfBinaryTree144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
        } else {
            return;
        }
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
