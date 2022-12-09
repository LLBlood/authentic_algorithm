package cn.liulin.algorithm.leetcode.code.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 989. 数组形式的整数加法
 * @author ll
 * @date 2022-12-09 10:04:17
 **/
public class IntegerAddition989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int more = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int i1 = num[i];
            int i2 = 0;
            if (k > 0) {
                i2 = k % 10;
                k = k / 10;
            }
            int i3 = i1 + i2 + more;
            int i4 = i3 % 10;
            list.add(0, i4);
            more = i3 / 10;
        }
        while (k > 0) {
            int i2 = k % 10;
            k = k / 10;
            int i3 = i2 + more;
            int i4 = i3 % 10;
            list.add(0, i4);
            more = i3 / 10;
        }
        if (more > 0) {
            list.add(0, more);
        }
        return list;
    }
}
