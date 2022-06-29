package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 617. 合并二叉树
 * @author ll
 * @date 2022-06-29 14:16:45
 **/
public class MergeBinaryTree617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return root1;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else if (root1 == null) {
            return root2;
        } else {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
