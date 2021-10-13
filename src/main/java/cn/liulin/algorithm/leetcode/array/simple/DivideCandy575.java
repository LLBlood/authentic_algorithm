package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 575. 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * @author ll
 * @date 2021-10-13 14:00:32
 **/
public class DivideCandy575 {
    /**
     * 自定义：暴力法
     * @author ll
     * @date 2021-10-13 14:05:59
     * @param candyType
     * @return int
     **/
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>(candyType.length);
        for (int i : candyType) {
            set.add(i);
        }
        int size = set.size();
        return Math.min(size, candyType.length / 2);
    }
}
