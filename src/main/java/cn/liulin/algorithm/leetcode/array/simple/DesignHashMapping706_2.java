package cn.liulin.algorithm.leetcode.array.simple;

import sun.security.provider.MD5;

import java.util.Objects;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 706. 设计哈希映射
 * @author ll
 * @date 2022-07-11 13:46:33
 **/
public class DesignHashMapping706_2 {
    LinkedNode[] linkedNodes = null;
    public DesignHashMapping706_2() {
        linkedNodes = new LinkedNode[36];
    }

    public void put(int key, int value) {
        int i = key % linkedNodes.length;
        LinkedNode linkedNode = linkedNodes[i];
        if (linkedNode == null) {
            linkedNodes[i] = new LinkedNode(value, key);
        } else {
            while (linkedNode != null) {
                if (linkedNode.getKey() == key) {
                    linkedNode.setValue(value);
                    break;
                } else if (linkedNode.getNext() == null) {
                    linkedNode.setNext(new LinkedNode(value, key));
                    break;
                } else {
                    linkedNode = linkedNode.getNext();
                }
            }
        }
    }

    public int get(int key) {
        int i = key % linkedNodes.length;
        LinkedNode linkedNode = linkedNodes[i];
        if (linkedNode == null) {
            return -1;
        } else {
            while (linkedNode != null) {
                if (linkedNode.getKey() == key) {
                    return linkedNode.getValue();
                } else {
                    linkedNode = linkedNode.getNext();
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int i = key % linkedNodes.length;
        LinkedNode linkedNode = linkedNodes[i];
        LinkedNode pre = null;
        while (linkedNode != null) {
            if (linkedNode.getKey() == key) {
                if (pre == null) {
                    linkedNodes[i] = linkedNode.getNext();
                } else {
                    pre.setNext(linkedNode.getNext());
                }
                break;
            } else {
                pre = linkedNode;
                linkedNode = linkedNode.getNext();
            }
        }
    }
}

class LinkedNode {
    private int value;
    private int key;
    private LinkedNode next;

    public LinkedNode(int value, int key) {
        this.value = value;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
