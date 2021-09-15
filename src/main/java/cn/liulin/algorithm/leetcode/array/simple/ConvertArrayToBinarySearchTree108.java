package cn.liulin.algorithm.leetcode.array.simple;

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

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author ll
 * @date 2021-09-15 14:26:17
 **/
public class ConvertArrayToBinarySearchTree108 {
    /**
     * 递归中序靠左遍历
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArray(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        int index = (start + end) >> 1;
        treeNode.val = nums[index];
        treeNode.left = sortedArray(nums, start, index - 1);
        treeNode.right = sortedArray(nums, index + 1, end);
        return treeNode;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
