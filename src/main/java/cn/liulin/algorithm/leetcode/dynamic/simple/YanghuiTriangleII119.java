package cn.liulin.algorithm.leetcode.dynamic.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.dynamic.simple$
 * 119. 杨辉三角 II
 * @author ll
 * @date 2022-10-20 09:42:06
 **/
public class YanghuiTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tempList = new ArrayList<>(1);
        tempList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> currList = new ArrayList<>(i);
            currList.add(1);
            for (int j = 1; j < i; j++) {
                currList.add(tempList.get(j - 1) + tempList.get(j));
            }
            currList.add(1);
            tempList = currList;
        }
        return tempList;
    }
}
