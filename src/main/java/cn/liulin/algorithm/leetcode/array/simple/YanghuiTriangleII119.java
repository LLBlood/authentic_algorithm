package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 119. 杨辉三角 II
 * @author ll
 * @date 2022-07-11 14:24:57
 **/
public class YanghuiTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new LinkedList<>();
        pre.add(1);
        if (rowIndex == 0) {
            return pre;
        }
        for (int i = 1; i <= rowIndex; i++) {
            pre.add(1);
            int cur = i - 1;
            while (cur - 1 >= 0) {
                pre.set(cur, pre.get(cur - 1) + pre.get(cur));
                cur--;
            }
        }
        return pre;
    }
}
