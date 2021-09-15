package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @author ll
 * @date 2021-09-15 15:32:26
 **/
public class YangHuiTriangle118 {

    /**
     * 自定义：数学推导法
     * @author ll
     * @date 2021-09-15 17:49:57
     * @param numRows
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    List<Integer> beforeList = list.get(i - 1);
                    temp.add(beforeList.get(j) + beforeList.get(j - 1));
                }
            }
            list.add(temp);
        }
        return list;
    }
}
