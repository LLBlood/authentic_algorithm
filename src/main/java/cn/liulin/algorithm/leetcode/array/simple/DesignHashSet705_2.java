package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 官方题解法
 *
 * @author ll
 * @date 2021-10-18 13:24:34
 **/
public class DesignHashSet705_2 {
    private static final int BASE = 769;
    private List<Integer>[] data;

    public DesignHashSet705_2() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == key) {
                return;
            }
        }
        data[hash].add(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == key) {
                iterator.remove();
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
