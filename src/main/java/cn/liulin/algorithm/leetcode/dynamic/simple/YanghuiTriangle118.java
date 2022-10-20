package cn.liulin.algorithm.leetcode.dynamic.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.dynamic.simple$
 * 118. 杨辉三角
 * @author ll
 * @date 2022-10-19 17:33:53
 **/
public class YanghuiTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>(1);
        tempList.add(1);
        list.add(tempList);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> currList = new ArrayList<>(i);
            currList.add(1);
            for (int j = 1; j < i - 1; j++) {
                int cur = tempList.get(j - 1) + tempList.get(j);
                currList.add(cur);
            }
            currList.add(1);
            list.add(currList);
            tempList = currList;
        }
        return list;
    }
}
