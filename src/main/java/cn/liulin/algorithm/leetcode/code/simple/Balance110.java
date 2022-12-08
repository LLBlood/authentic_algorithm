package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 110. 平衡二叉树
 * @author ll
 * @date 2022-12-06 17:11:03
 **/
public class Balance110 {
    /**
     * 自顶向下
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * 自底向上
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
