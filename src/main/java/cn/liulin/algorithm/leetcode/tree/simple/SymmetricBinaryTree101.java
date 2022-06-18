package cn.liulin.algorithm.leetcode.tree.simple;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * cn.liulin.algorithm.leetcode.tree.simple$
 * 101. 对称二叉树
 * @author ll
 * @date 2022-06-18 19:19:22
 **/
public class SymmetricBinaryTree101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int size = queue.size();
            if (size % 2 != 0) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
                list.add(poll);
            }
            int m = 0; int j = list.size() - 1;
            while (m < j) {
                TreeNode mTreeNode = list.get(m);
                TreeNode jTreeNode = list.get(j);
                if (mTreeNode == null && jTreeNode == null) {
                    m++;
                    j--;
                } else if (mTreeNode == null || jTreeNode == null) {
                    return false;
                } else if (mTreeNode.val != jTreeNode.val) {
                    return false;
                } else {
                    m++;
                    j--;
                }
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric3(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
