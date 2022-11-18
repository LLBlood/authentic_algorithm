package cn.liulin.algorithm.leetcode.code.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 589. N 叉树的前序遍历
 * @author ll
 * @date 2022-11-18 17:36:23
 **/
public class PreorderTraversal589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            list.add(root.val);
            setListData(list, root.children);
        }
        return list;
    }

    private void setListData(List<Integer> list, List<Node> children) {
        if (children != null && !children.isEmpty()) {
            for (Node child : children) {
                if (child != null) {
                    list.add(child.val);
                    setListData(list, child.children);
                }
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
