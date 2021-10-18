package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 官方题解法：设计链表数组
 * @author ll
 * @date 2021-10-18 13:32:59
 **/
public class DesignHashMapping706 {
    private static final int BASE = 769;
    private LinkedList<Pair>[] data;

    class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
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
    }

    public DesignHashMapping706() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<Pair> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                next.setValue(value);
                return;
            }
        }
        Pair pair = new Pair(key, value);
        data[hash].add(pair);
    }

    public int get(int key) {
        int hash = hash(key);
        Iterator<Pair> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                return next.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Pair> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                iterator.remove();
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
