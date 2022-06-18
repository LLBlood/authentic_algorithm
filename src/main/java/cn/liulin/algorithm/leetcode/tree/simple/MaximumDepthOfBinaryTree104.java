package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 104. 二叉树的最大深度
 * @author ll
 * @date 2022-06-18 18:42:35
 **/
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int i) {
        if (root == null) {
            return i;
        }
        int l1 = maxDepth(root.left, i + 1);
        int r1 = maxDepth(root.right, i + 1);
        return Math.max(l1, r1);
    }
}
