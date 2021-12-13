package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1356. 根据数字二进制下 1 的数目排序
 * @author ll
 * @date 2021-12-13 14:25:49
 **/
public class SortAccordUnderBinary1356 {
    /**
     * 暴力法
     * @author ll
     * @date 2021-12-13 14:52:58
     * @param arr
     * @return int[]
     **/
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>(n);
        for (int i : arr) {
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = 0;
            if (i >= 2) {
                while (i >= 2) {
                    int i1 = i % 2;
                    i /= 2;
                    if (i1 == 1) {
                        temp[1] += 1;
                    }
                }
            }
            if (i == 1) {
                temp[1] += 1;
            }
            list.add(temp);
        }

        list.sort((o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return -1;
            }
        });
        int[] intArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intArr[i] = list.get(i)[0];
        }
        return intArr;
    }
}
