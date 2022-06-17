package cn.liulin.algorithm.leetcode.pojo;

/**
 * cn.liulin.algorithm.leetcode.pojo$
 *
 * @author ll
 * @date 2022-06-17 20:39:50
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
