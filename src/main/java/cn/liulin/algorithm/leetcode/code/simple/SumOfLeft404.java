package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 404. 左叶子之和
 * @author ll
 * @date 2022-11-24 18:11:03
 **/
public class SumOfLeft404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.left != null) {
            val = root.left.val;
        }
        return getLeft(root.left, val) + getLeft(root.right, 0);
    }

    private int getLeft(TreeNode node, int val) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return val;
        }
        int valZ = 0;
        if (node.left != null) {
            valZ = node.left.val;
        }
        return getLeft(node.left, valZ) + getLeft(node.right, 0);
    }
}