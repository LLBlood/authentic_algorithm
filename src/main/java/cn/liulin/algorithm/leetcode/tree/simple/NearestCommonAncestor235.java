package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 235. 二叉搜索树的最近公共祖先
 * @author ll
 * @date 2022-06-21 15:08:52
 **/
public class NearestCommonAncestor235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int m = Math.max(p.val, q.val);
        int n = Math.min(p.val, q.val);
        return lowestCommonAncestor(root, m, n);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int m, int n) {
        if (root.val >= n && root.val <= m) {
            return root;
        } else if (root.val <= n) {
            return lowestCommonAncestor(root.right, m, n);
        } else {
            return lowestCommonAncestor(root.left, m, n);
        }
    }
}
