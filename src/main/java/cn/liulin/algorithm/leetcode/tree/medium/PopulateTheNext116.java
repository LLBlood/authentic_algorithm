package cn.liulin.algorithm.leetcode.tree.medium;

import cn.liulin.algorithm.leetcode.pojo.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * cn.liulin.algorithm.leetcode.tree.medium$
 * 116. 填充每个节点的下一个右侧节点指针
 * @author ll
 * @date 2022-06-29 14:33:14
 **/
public class PopulateTheNext116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node left, Node right) {
        if (left != null && right != null) {
            left.next = right;
            connect(left.left, left.right);
            connect(left.right, right.left);
            connect(right.left, right.right);
        }
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Node node = null;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    if (node == null) {
                        node = queue1.poll();
                    } else {
                        node.next = queue1.poll();
                        node = node.next;
                    }
                    if (node.left != null) {
                        queue2.add(node.left);
                        queue2.add(node.right);
                    }
                }
            } else {
                while (!queue2.isEmpty()) {
                    if (node == null) {
                        node = queue2.poll();
                    } else {
                        node.next = queue2.poll();
                        node = node.next;
                    }
                    if (node.left != null) {
                        queue1.add(node.left);
                        queue1.add(node.right);
                    }
                }
            }
        }
        return root;
    }

    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue1 = new LinkedList<>();
        queue1.offer(root);
        int i = 0;
        while (!queue1.isEmpty()) {
            Node poll = null;
            int sum = (int) Math.pow(2, i);
            for (int j = 0; j < sum; j++) {
                if (j == 0) {
                    poll = queue1.poll();
                } else {
                    poll.next = queue1.poll();
                    poll = poll.next;
                }
                if (poll != null && poll.left != null) {
                    queue1.add(poll.left);
                    queue1.add(poll.right);
                }
            }
            i++;
        }
        return root;
    }

    public Node connect4(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }
}
