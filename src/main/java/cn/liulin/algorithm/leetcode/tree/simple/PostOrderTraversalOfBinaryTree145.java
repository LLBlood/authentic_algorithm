package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 145. 二叉树的后序遍历
 * @author ll
 * @date 2022-06-17 20:54:33
 **/
public class PostOrderTraversalOfBinaryTree145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }

}
