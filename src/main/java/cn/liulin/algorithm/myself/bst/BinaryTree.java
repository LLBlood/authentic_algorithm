package cn.liulin.algorithm.myself.bst;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.myself.bst$
 *
 * @author ll
 * @date 2023-10-10 14:19:33
 **/
public class BinaryTree {

    public static void main(String[] args) {
        Node baseNode = createBaseNode();
        // 前序遍历
        List<Integer> preOrderList = preOrder(baseNode, false);
        System.out.println("前序遍历的结果：" + preOrderList);
        // 中序遍历
        List<Integer> inorderTraversalList = inorderTraversal(baseNode, false);
        System.out.println("中序遍历的结果：" + inorderTraversalList);
        // 后序遍历
        List<Integer> postorderTraversalList = postorderTraversal(baseNode, false);
        System.out.println("后序遍历的结果：" + postorderTraversalList);

    }

    private static List<Integer> preOrder(Node baseNode, boolean hasNull) {
        List<Integer> preOrderList = new LinkedList<>();
        preOrderExecute(preOrderList, baseNode, hasNull);
        return preOrderList;
    }

    private static void preOrderExecute(List<Integer> preOrderList, Node baseNode, boolean hasNull) {
        if (baseNode == null) {
            if (hasNull) {
                preOrderList.add(null);
            }
            return;
        }
        preOrderList.add(baseNode.value);
        preOrderExecute(preOrderList, baseNode.leftNode, hasNull);
        preOrderExecute(preOrderList, baseNode.rightNode, hasNull);
    }

    private static List<Integer> inorderTraversal(Node baseNode, boolean hasNull) {
        List<Integer> inorderTraversalList = new LinkedList<>();
        inorderTraversalExecute(inorderTraversalList, baseNode, hasNull);
        return inorderTraversalList;
    }

    private static void inorderTraversalExecute(List<Integer> inorderTraversalList, Node baseNode, boolean hasNull) {
        if (baseNode == null) {
            if (hasNull) {
                inorderTraversalList.add(null);
            }
            return;
        }
        inorderTraversalExecute(inorderTraversalList, baseNode.leftNode, hasNull);
        inorderTraversalList.add(baseNode.value);
        inorderTraversalExecute(inorderTraversalList, baseNode.rightNode, hasNull);
    }

    private static List<Integer> postorderTraversal(Node baseNode, boolean hasNull) {
        List<Integer> postorderTraversalList = new LinkedList<>();
        postorderTraversalExecute(postorderTraversalList, baseNode, hasNull);
        return postorderTraversalList;
    }

    private static void postorderTraversalExecute(List<Integer> postorderTraversalList, Node baseNode, boolean hasNull) {
        if (baseNode == null) {
            if (hasNull) {
                postorderTraversalList.add(null);
            }
            return;
        }
        postorderTraversalExecute(postorderTraversalList, baseNode.leftNode, hasNull);
        postorderTraversalExecute(postorderTraversalList, baseNode.rightNode, hasNull);
        postorderTraversalList.add(baseNode.value);
    }

    public static Node createBaseNode() {
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        node4.leftNode = node2;
        node2.leftNode = node1;
        node2.rightNode = node3;
        node4.rightNode = node6;
        node6.leftNode = node5;
        node6.rightNode = node7;
        return node4;
    }


    public static class Node {
        private int value;
        private Node leftNode;
        private Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
}
