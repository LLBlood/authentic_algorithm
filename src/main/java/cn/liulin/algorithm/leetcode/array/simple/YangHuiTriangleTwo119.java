package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * @author ll
 * @date 2021-09-15 17:58:25
 **/
public class YangHuiTriangleTwo119 {
    /**
     * 自定义：递推法
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
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
        return list.get(rowIndex);
    }

    /**
     * 官方题解法：滚筒法
     * @author ll
     * @date 2021-09-15 18:08:32
     * @param rowIndex
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(j) + list.get(j - 1));
                }
            }
            list = temp;
        }
        return list;
    }

    /**
     * 进一步优化滚筒法
     * @author ll
     * @date 2021-09-15 18:13:49
     * @param rowIndex
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        list.add(1);
        for (int i = 1;i <= rowIndex; i++) {
            list.add(0);
            for (int j = i; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}
