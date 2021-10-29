package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 989. 数组形式的整数加法
 * @author ll
 * @date 2021-10-29 13:31:40
 **/
public class IntegerAdditionInArray989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new LinkedList<>();
        String kStr = String.valueOf(k);
        int numIndex = num.length - 1;
        int kIndex = kStr.length() - 1;
        int pre = 0;
        while (numIndex >= 0 || kIndex >= 0) {
            int n = 0;
            int z = 0;
            if (numIndex >= 0) {
                n = num[numIndex];
            }
            if (kIndex >= 0) {
                z = (kStr.charAt(kIndex) - 48);
            }
            int sum = n + z + pre;
            if (sum > 9) {
                pre = 1;
                sum = sum - 10;
            } else {
                pre = 0;
            }
            list.add(0, sum);
            numIndex--;
            kIndex--;
        }
        if (pre != 0) {
            list.add(0, pre);
        }
        return list;
    }

    public List<Integer> addToArrayForm2(int[] num, int k) {
        List<Integer> list = new LinkedList<>();
        int n = num.length - 1;
        for (int i = n; i >= 0; i--) {
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum > 9) {
                k++;
                sum -= 10;
            }
            list.add(sum);
        }
        for (; k > 0; k /= 10) {
            list.add(k % 10);
        }
        Collections.reverse(list);
        return list;
    }
}
