package cn.liulin.algorithm.leetcode.tree.simple;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 *
 * @author ll
 * @date 2023-10-10 14:55:23
 **/
public class IncrementalOrderLCR052 {
    TreeNode node = new TreeNode();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = node;
        inOrderBST(root);
        return result.right;
    }

    private void inOrderBST(TreeNode root) {
        if (root != null) {
            inOrderBST(root.left);
            TreeNode temp = new TreeNode();
            temp.val = root.val;
            node.right = temp;
            node = node.right;
            inOrderBST(root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
