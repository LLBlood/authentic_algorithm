package cn.liulin.algorithm.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.algorithm.medium$
 * 120. 三角形最小路径和
 * @author ll
 * @date 2022-07-04 17:38:19
 **/
public class TriangleMinimum120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        } else if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<List<Integer>> list = new ArrayList<>(triangle.size());
        list.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> integers1 = triangle.get(i);
            List<Integer> tempList = new ArrayList<>(integers1.size());
            list.add(tempList);
            List<Integer> preList = list.get(i - 1);
            if (i < triangle.size() - 1) {
                for (int j = 0; j < integers1.size(); j++) {
                    Integer integer = integers1.get(j);
                    if (j > 0 && preList.size() > j) {
                        tempList.add(Math.min(preList.get(j - 1) + integer, preList.get(j) + integer));
                    } else {
                        tempList.add(preList.get(0) + integer);
                    }
                }
            } else {
                Integer min1 = Collections.min(integers1);
                int i1 = integers1.indexOf(min1);
                Integer min2 = Collections.min(preList);
                int i2 = preList.indexOf(min2);
                int min4 = Math.min(min2 + integers1.get(i2), min2 + integers1.get(i2 + 1));
                if (i1 > 0 && preList.size() > i1) {
                    int min3 = Math.min(preList.get(i1) + min1, preList.get(i1 - 1) + min1);
                    return Math.min(min3, min4);
                } else {
                    int min3 = preList.get(i1 - 1) + min1;
                    return Math.min(min3, min4);
                }
            }
        }
        return 0;
    }
}
