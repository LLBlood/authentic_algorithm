package cn.liulin.algorithm.myself.bst;

/**
 * cn.liulin.algorithm.myself$
 * 二叉树，二叉搜索树BST
 * 特性：
 *  若任意节点的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
 *  若任意节点的右子树不为空，则右子树上所有节点的值均大于它的根节点的值；
 *  任意节点的左右树也分别为二叉查找树
 * @author ll
 * @date 2022-04-14 10:23:51
 **/
public class BinarySearchTree {
    /**
     * 树根，所有的操作均始于此
     */
    private Node root;

    /**
     * 插入节点
     * 1.若root为null，则将插入节点赋值为root
     * 2.当前元素与插入元素通过compareTo进行比较，若插入元素值小，并且左子节点left为空，则插入至当前节点左子节点；否则继续递归
     * 3.若插入元素值大，且右子节点right为空，则插入至当前节点右子节点；否则继续递归
     */
    public boolean add(int element) {
        if (root == null) {
            root = new Node(element);
            return true;
        }
        return add(root, element);
    }

    /**
     * 添加元素递归
     * @author ll
     * @date 2022-04-14 10:40:26
     * @param node
     * @param element
     * @return boolean
     **/
    private boolean add(Node node, int element) {
        if (node.compareTo(element) < 0) {
            if (node.left == null) {
                node.left = new Node(element);
                return true;
            } else {
                return add(node.left, element);
            }
        } else if (node.compareTo(element) == 0) {
            return false;
        } else {
            if (node.right == null) {
                node.right = new Node(element);
                return true;
            } else {
                return add(node.right, element);
            }
        }
    }

    /**
     * 查找节点
     * 1.若root为空，则查找失败
     * 2.将当前元素与目标元素对比，若相等则查找成功
     * 3.若不相等，则继续递归查找；若目标值小于当前节点值，则查找左子树，否则查找右子树
     * @author ll
     * @date 2022-04-14 10:44:44
     * @param element
     * @return cn.liulin.algorithm.myself.bst.BinarySearchTree.Node
     **/
    public Node find(int element) {
        if (root == null) {
            return null;
        }
        return find(root, element);
    }

    /**
     * 查找节点递归
     * @author ll
     * @date 2022-04-14 10:53:37
     * @param node
     * @param element
     * @return cn.liulin.algorithm.myself.bst.BinarySearchTree.Node
     **/
    private Node find(Node node, int element) {
        if (node == null) {
            return null;
        }
        if (node.compareTo(element) == 0) {
            return node;
        } else if (node.compareTo(element) < 0) {
            return find(node.left, element);
        } else {
            return find(node.right, element);
        }
    }

    /**
     * 顺序遍历节点
     * @author ll
     * @date 2022-04-14 10:58:49
     * @return void
     **/
    public void orderPrint() {
        orderPrint(root);
    }

    /**
     * 顺序遍历节点递归
     * @author ll
     * @date 2022-04-14 11:01:07
     * @param node
     * @return void
     **/
    private void orderPrint(Node node) {
        if (node == null) {
            return;
        }

        // 递归遍历左子节点
        orderPrint(node.left);

        // 输出当前节点
        System.out.println(node.element);

        // 递归遍历右子节点
        orderPrint(node.right);
    }

    /**
     * 删除节点
     * 1.有一个子节点的节点
     *  将节点删除，让父节点连接子节点即可，因为子节点与父节点的关系 = 当前节点与父节点的关系，并不改变树的性质
     * 2.删除有两个子节点的节点
     *  我们可以通过交换节点的方式，让要删除节点和只有一个子节点的节点交换，删除节点的操作就变成了上面的情况。
     * @author ll
     * @date 2022-04-14 11:03:27
     * @param element
     * @return boolean
     **/
    public boolean remove(int element) {
        if (root == null) {
            return false;
        }
        Node parentNode = root;
        Node tmpNode = root;
        while (tmpNode != null && tmpNode.compareTo(element) != 0) {
            parentNode = tmpNode;
            if (tmpNode.compareTo(element) > 0) {
                tmpNode = tmpNode.right;
            } else {
                tmpNode = tmpNode.left;
            }
        }
        if (tmpNode == null) {
            return false;
        }
        // 只有一个子节点或者没有子节点的情况
        if (tmpNode.right == null || tmpNode.left == null) {
            if (tmpNode.right != null) {
                // 删除根节点，直接用子节点替代
                if (tmpNode == root) {
                    root = tmpNode.right;
                    return true;
                }
                // 判断当前节点与父节点的关系
                if (parentNode.right == tmpNode) {
                    parentNode.right = tmpNode.right;
                } else {
                    parentNode.left = tmpNode.right;
                }
            } else {
                // 删除根节点，直接用子节点替代
                if (tmpNode == root) {
                    root = tmpNode.left;
                    return true;
                }
                // 判断当前节点与父节点的关系
                if (parentNode.right == tmpNode) {
                    parentNode.right = tmpNode.left;
                } else {
                    parentNode.left = tmpNode.left;
                }
            }
            return true;
        }

        // 有两个子节点的情况，寻找中序遍历的后一个节点，也就是右子树进行中序遍历的第一个节点，右子树的最左节点，先找到要删除节点的右子树中序遍历的第一个节点
        Node rightFirstLeftNode = tmpNode.right;
        if (rightFirstLeftNode.left != null) {
            parentNode = rightFirstLeftNode;
            rightFirstLeftNode = rightFirstLeftNode.left;
        }

        // 将右子树中最小刚好又大于被删除节点值赋值给被删除节点
        tmpNode.element = rightFirstLeftNode.element;

        if (parentNode.left == rightFirstLeftNode) {
            parentNode.left = rightFirstLeftNode.right;
        } else {
            parentNode.right = rightFirstLeftNode.right;
        }
        return true;
    }


    /**
     * cn.liulin.algorithm.myself.bst$
     * 二叉树要求所有的节点元素都能够排序
     * @author ll
     * @date 2022-04-14 10:28:07
     **/
    class Node implements Comparable<Integer> {

        /**
         * 数据元素
         */
        private int element;

        /**
         * 左子树
         */
        private Node left;

        /**
         * 右子树
         */
        private Node right;

        private Node(int element) {
            this.element = element;
        }

        @Override
        public int compareTo(Integer o) {
            return o.compareTo(element);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(1);
        binarySearchTree.add(6);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        binarySearchTree.add(10);
        binarySearchTree.add(16);
        binarySearchTree.add(3);
        binarySearchTree.orderPrint();

        Node node = binarySearchTree.find(4);
        System.out.println(node.element);

        node = binarySearchTree.find(11);
        System.out.println(node);

        boolean remove = binarySearchTree.remove(4);
        System.out.println(remove);
        binarySearchTree.orderPrint();
    }
}

