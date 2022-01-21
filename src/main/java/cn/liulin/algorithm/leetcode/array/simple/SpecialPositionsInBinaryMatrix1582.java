package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1582. 二进制矩阵中的特殊位置
 * @author ll
 * @date 2022-01-21 13:28:07
 **/
public class SpecialPositionsInBinaryMatrix1582 {
    public int numSpecial(int[][] mat) {
        List<int[]> list = new LinkedList<>();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    int[] temp = {i, j};
                    list.add(temp);
                    xMap.put(i, xMap.getOrDefault(i, 0) + 1);
                    yMap.put(j, yMap.getOrDefault(j, 0) + 1);
                }
            }
        }
        int count = 0;
        for (int[] ints : list) {
            int i = ints[0];
            int j = ints[1];
            if (xMap.get(i) == 1 && yMap.get(j) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
        new SpecialPositionsInBinaryMatrix1582().numSpecial(mat);
    }
}
