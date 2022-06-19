package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 112. 路径总和
 * @author ll
 * @date 2022-06-19 18:52:10
 **/
public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, root.val, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int i, int targetSum) {
        if (root.left == null && root.right == null) {
            return i == targetSum;
        }
        boolean flagL = false;
        boolean flagR = false;
        if (root.left != null) {
            flagL = hasPathSum(root.left, i + root.left.val, targetSum);
        }
        if (root.right != null) {
            flagR = hasPathSum(root.right, i + root.right.val, targetSum);
        }
        return flagL || flagR;
    }
}
