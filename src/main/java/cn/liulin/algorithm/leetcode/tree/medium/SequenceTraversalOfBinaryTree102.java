package cn.liulin.algorithm.leetcode.tree.medium;

import cn.liulin.algorithm.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * cn.liulin.algorithm.leetcode.tree.medium$
 * 102. 二叉树的层序遍历
 * @author ll
 * @date 2022-06-18 18:07:47
 **/
public class SequenceTraversalOfBinaryTree102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> list, int i) {
        if (root == null) {
            return;
        }
        List<Integer> tempList = null;
        if (list.size() == i) {
            tempList = new LinkedList<>();
            list.add(tempList);
        } else {
            tempList = list.get(i);
        }
        tempList.add(root.val);
        levelOrder(root.left, list, i + 1);
        levelOrder(root.right, list, i + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
