package cn.liulin.algorithm.leetcode.tree.medium;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.tree.medium$
 * 98. 验证二叉搜索树
 * @author ll
 * @date 2022-06-21 11:43:28
 **/
public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        isValidBST(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void isValidBST(TreeNode root, List<Integer> list) {
        if (root != null) {
            isValidBST(root.left, list);
            list.add(root.val);
            isValidBST(root.right, list);
        }
    }

    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
