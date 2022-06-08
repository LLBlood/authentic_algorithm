package cn.liulin.algorithm.myself.bst;

import sun.security.x509.AVA;

/**
 * cn.liulin.algorithm.myself.bst$
 * 平衡二叉树
 * @author ll
 * @date 2022-05-10 14:33:14
 **/
public class AVLTree {
    AVLNode root;

    /**
     * 插入数据
     * @author ll
     * @date 2022-05-10 15:52:28
     * @param data 数据
     **/
    public void insert(int data) {
        if (this.root == null) {
            this.root = new AVLNode(data);
        } else {
            this.root = insert(this.root, data);
        }
    }

    /**
     * 递归插入数据
     * @author ll
     * @date 2022-05-10 15:53:49
     * @param root 父节点
     * @param data 数据
     * @return cn.liulin.algorithm.myself.bst.AVLNode
     **/
    private AVLNode insert(AVLNode root, int data) {
        // 插入左子树
        if (data < root.data) {
            if (root.left == null) {
                root.left = new AVLNode(data);
                root.left.parent = root;
            } else {
                insert(root.left, data);
            }
        } else if (data > root.data) {
            // 插入右子树
            if (root.right == null) {
                root.right = new AVLNode(data);
                root.right.parent = root;
            } else {
                insert(root.right, data);
            }
        } else {
            return root;
        }
        // 刷新高度
        root.height = calcHeight(root);
        // 旋转
        // 1.LL型右旋转
        if (calcBF(root) == 2) {
            // 2.LR型先左旋转
            if (calcBF(root.left) == -1) {
                root.left = leftRotate(root.left);
            }
            root = rightRotate(root);
        }
        // 3.RR型左旋转
        if (calcBF(root) == -2) {
            // 4.RL型先右旋转
            if (calcBF(root.right) == 1) {
                root.right = rightRotate(root.right);
            }
            root = leftRotate(root);
        }
        return root;
    }

    /**
     * 通过子树高度计算高度
     * @author ll
     * @date 2022-05-10 14:37:39 
     * @param node 节点
     * @return int
     **/
    public int calcHeight(AVLNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.right == null) {
            return node.left.height + 1;
        } else if (node.left == null) {
            return node.right.height + 1;
        } else {
            return node.left.height > node.right.height ? node.left.height + 1 : node.right.height + 1;
        }
    }
    
    /**
     * 计算BF（平衡因子）的值为：左子树高度 - 右子树高度
     * @author ll
     * @date 2022-05-10 14:42:22
     * @param node 节点
     * @return int
     **/
    public int calcBF(AVLNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 0;
        } else if (node.right == null) {
            return node.left.height;
        } else if (node.left == null) {
            return - node.right.height;
        } else {
            return node.left.height - node.right.height;
        }
    }

    /**
     * 左旋
     * 旧节点是当前节点，新节点是当前节点的右子树
     * 旧节点成为新节点的左子树
     * 新节点的左子树如果不为空，则变为旧节点的右子树
     * @author ll
     * @date 2022-05-10 14:55:06
     * @param node 节点
     * @return cn.liulin.algorithm.myself.bst.AVLNode
     **/
    public AVLNode leftRotate(AVLNode node) {
        AVLNode newNode = node.right;
        AVLNode parentNode = node.parent;
        // 1.newNode替换当前节点位置
        if (parentNode != null) {
            if (parentNode.data > node.data) {
                parentNode.left = newNode;
            } else {
                parentNode.right = newNode;
            }
        }
        newNode.parent = parentNode;
        // 2.重新组装当前节点（将newNode的左子树给当前节点的右子树）
        node.right = newNode.left;
        if (newNode.left != null) {
            newNode.left.parent = node;
        }
        // 3.当前Node为newNode的左子树
        newNode.left = node;
        node.parent = newNode;
        // 刷新高度
        node.height = calcHeight(node);
        newNode.height = calcHeight(newNode);
        return newNode;
    }

    /**
     * 右旋
     * 旧节点是当前节点，新节点是当前节点的左子树
     * 旧节点成为新节点的右子树
     * 新节点的右子树如果不为空，则变成旧节点的左子树
     * @author ll
     * @date 2022-05-10 15:37:44
     * @param node 节点
     * @return cn.liulin.algorithm.myself.bst.AVLNode
     **/
    public AVLNode rightRotate(AVLNode node) {
        AVLNode newNode = node.left;
        AVLNode parentNode = node.parent;
        // 1.设置新节点的位置
        if (parentNode != null) {
            if (parentNode.data > node.data) {
                parentNode.left = newNode;
            } else {
                parentNode.right = newNode;
            }
        }
        newNode.parent = parentNode;
        // 2.重新组装当前节点（将newNode的右子树给当前节点的左子树）
        node.left = newNode.right;
        if (newNode.right != null) {
            newNode.right.parent = node;
        }
        // 3.当前节点为newNode的左子树
        newNode.right = node;
        node.parent = newNode;
        // 刷新高度
        node.height = calcHeight(node);
        newNode.height = calcHeight(newNode);
        return newNode;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        //遍历输出
        innerTraverse(tree.root);
    }
    private static void innerTraverse(AVLNode root) {
        if (root == null) {
            return;
        }
        innerTraverse(root.left);
        System.out.println(root.data + " height:" + root.height);
        innerTraverse(root.right);
    }
}

/**
 * 平衡二叉树节点
 * @author ll
 * @date 2022-05-10 14:34:45
 **/
class AVLNode {
    /**
     * 数据
     */
    public int data;

    /**
     * 相对高度
     */
    public int height;

    /**
     * 父节点
     */
    public AVLNode parent;

    /**
     * 左子树
     */
    public AVLNode left;

    /**
     * 右子树
     */
    public AVLNode right;
    public AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }
}
