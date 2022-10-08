package cn.liulin.algorithm.leetcode.tree.medium;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

/**
 * cn.liulin.algorithm.leetcode.tree.medium$
 * 173. 二叉搜索树迭代器
 * @author ll
 * @date 2022-08-12 14:41:49
 **/
public class TreeIterator173 {

    TreeIterator173 next;
    TreeNode treeNode;

    public TreeIterator173(TreeNode root) {
        setTreeNode(root, this);
    }

    private void setTreeNode(TreeNode root, TreeIterator173 treeIterator173) {
        if (root != null) {
            if (root.left != null) {
                setTreeNode(root.left, this);
            }
        }
    }

    public int next() {
        return -1;
    }

    public boolean hasNext() {
        return false;
    }
}
