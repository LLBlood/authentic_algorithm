package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 705. 设计哈希集合
 * @author ll
 * @date 2021-10-18 11:25:35
 **/
public class DesignHashSet705 {
    Integer curValue = null;
    DesignHashSet705 next = null;

    public DesignHashSet705() {
    }

    public void add(int key) {
        DesignHashSet705 cur = this;
        while (true) {
            if (cur.next == null) {
                DesignHashSet705 designHashSet705 = new DesignHashSet705();
                designHashSet705.curValue = key;
                cur.next = designHashSet705;
                break;
            } else if (cur.next.curValue != key) {
                cur = cur.next;
            } else {
                break;
            }
        }
    }

    public void remove(int key) {
        DesignHashSet705 cur = this;
        while (true) {
            if (cur.next == null) {
                break;
            } else if (cur.next.curValue != key) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
                break;
            }
        }
    }

    public boolean contains(int key) {
        DesignHashSet705 cur = this;
        while (true) {
            if (cur.next == null) {
                return false;
            } else if (cur.next.curValue != key) {
                cur = cur.next;
            } else {
                return true;
            }
        }
    }
}
